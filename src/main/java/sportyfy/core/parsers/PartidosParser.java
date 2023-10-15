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

/**
 * Clase que realiza el análisis de JSON para crear una lista de partidos jugados.
 */
public class PartidosParser {

    /**
     * Crea una lista de partidos jugados a partir de un JSON.
     * @param jsonsPartidosJugadosTotales JSON que contiene la lista de partidos jugados.
     * @param equipos Lista de equipos que participan en los partidos.
     * @return Lista de partidos jugados creada a partir del JSON.
     * @throws IOException Si ocurre un error al analizar el JSON.
     */
    public List<PartidoJugado> crearPartidos(List<String> jsonsPartidosJugadosTotales, List<Equipo> equipos) throws IOException {
        List<PartidoJugado> partidosJugados = new ArrayList<>();

        for (String jsonPartidosJugados : jsonsPartidosJugadosTotales) {
            partidosJugados.addAll(cargarPartidosDesdeArchivo(new File(jsonPartidosJugados), equipos));
        }

        return partidosJugados;
    }

    /**
     * Carga los partidos jugados desde un archivo JSON.
     * @param archivo Archivo JSON que contiene los partidos jugados.
     * @param equipos Lista de equipos que participan en los partidos.
     * @return Lista de partidos jugados creada a partir del archivo JSON.
     * @throws IOException Si ocurre un error al analizar el JSON.
     */
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
