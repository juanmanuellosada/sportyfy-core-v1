package sportyfy.core.constructores;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.PartidoAnterior;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructorPartidos {

    public List<PartidoAnterior> crearPartidos(List<String> jsonsPartidosTotales, List<Equipo> equipos) throws IOException {
        List<PartidoAnterior> partidosAnteriores = new ArrayList<>();

        for (String jsonPartidos : jsonsPartidosTotales) {
            partidosAnteriores.addAll(cargarPartidosDesdeArchivo(new File(jsonPartidos), equipos));
        }

        return partidosAnteriores;
    }

    private List<PartidoAnterior> cargarPartidosDesdeArchivo(File archivo, List<Equipo> equipos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<PartidoAnterior> partidosAnteriores = new ArrayList<>();

        // Crear un mapa de equipos por ID para una búsqueda eficiente
        Map<Integer, Equipo> equiposPorId = new HashMap<>();
        for (Equipo equipo : equipos) {
            equiposPorId.put(equipo.getId(), equipo);
        }

        List<PartidoAnterior> partidosArchivo = mapper.readValue(archivo.getName(), new TypeReference<List<PartidoAnterior>>() {});

        for (PartidoAnterior partidoAnterior : partidosArchivo) {
            // Buscar los equipos en el mapa por su ID
            Equipo equipoLocal = equiposPorId.get(partidoAnterior.getEquipoLocal().getId());
            Equipo equipoVisitante = equiposPorId.get(partidoAnterior.getEquipoVisitante().getId());

            if (equipoLocal != null && equipoVisitante != null) {
                partidoAnterior.setEquipoLocal(equipoLocal);
                partidoAnterior.setEquipoVisitante(equipoVisitante);
                partidosAnteriores.add(partidoAnterior);
            }
        }


        return partidosAnteriores;
    }
}
