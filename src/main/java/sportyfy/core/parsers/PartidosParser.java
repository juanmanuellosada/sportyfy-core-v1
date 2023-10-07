package sportyfy.core.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoJugado;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidosParser {

    public List<PartidoJugado> crearPartidos(List<String> jsonsPartidosJugadosTotales, List<Equipo> equipos) throws IOException {
        List<PartidoJugado> partidosJugados = new ArrayList<>();

        for (String jsonPartidosJugados : jsonsPartidosJugadosTotales) {
            partidosJugados.addAll(cargarPartidosDesdeArchivo(new File(jsonPartidosJugados), equipos));
        }

        return partidosJugados;
    }

    private List<PartidoJugado> cargarPartidosDesdeArchivo(File archivo, List<Equipo> equipos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<PartidoJugado> partidosJugados = new ArrayList<>();

        // Leer el archivo JSON y convertirlo en una lista de objetos Partido
        List<PartidoJugado> partidosArchivo = mapper.readValue(archivo.getName(), new TypeReference<List<PartidoJugado>>() {});

        // Crear un mapa de equipos por ID para una búsqueda eficiente
        Map<Integer, Equipo> equiposPorId = new HashMap<>();
        for (Equipo equipo : equipos) {
            equiposPorId.put(equipo.getId(), equipo);
        }

        for (PartidoJugado partidoJugado : partidosArchivo) {
            // Buscar los equipos en el mapa por su ID
            Equipo equipoLocal = equiposPorId.get(partidoJugado.getEquipoLocal().getId());
            Equipo equipoVisitante = equiposPorId.get(partidoJugado.getEquipoVisitante().getId());

            if (equipoLocal != null && equipoVisitante != null) {
                // Actualizar las referencias de equipos en el partido
                partidoJugado.setEquipoLocal(equipoLocal);
                partidoJugado.setEquipoVisitante(equipoVisitante);
                partidosJugados.add(partidoJugado);
            }
        }

        return partidosJugados;
    }
}
