package sportyfy.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructorPartidos {

    public List<Partido> crearPartidos(String rutaCarpeta, List<Equipo> equipos) {
        List<Partido> partidos = new ArrayList<>();

        for (Equipo equipo : equipos) {
            String nombreArchivo = "ultimos_enfrentamientos_" + equipo.getId() + ".json";
            File archivo = new File(rutaCarpeta, nombreArchivo);

            if (archivo.exists()) {
                List<Partido> partidosEquipo = cargarPartidosDesdeArchivo(archivo, equipos);
                partidos.addAll(partidosEquipo);
            }
        }

        return partidos;
    }

    private List<Partido> cargarPartidosDesdeArchivo(File archivo, List<Equipo> equipos) {
        ObjectMapper mapper = new ObjectMapper();
        List<Partido> partidos = new ArrayList<>();

        // Crear un mapa de equipos por ID para una búsqueda eficiente
        Map<Integer, Equipo> equiposPorId = new HashMap<>();
        for (Equipo equipo : equipos) {
            equiposPorId.put(equipo.getId(), equipo);
        }

        try {
            List<Partido> partidosArchivo = mapper.readValue(archivo, new TypeReference<List<Partido>>() {});

            for (Partido partido : partidosArchivo) {
                // Buscar los equipos en el mapa por su ID
                Equipo equipoLocal = equiposPorId.get(partido.getEquipoLocal().getId());
                Equipo equipoVisitante = equiposPorId.get(partido.getEquipoVisitante().getId());

                if (equipoLocal != null && equipoVisitante != null) {
                    partido.setEquipoLocal(equipoLocal);
                    partido.setEquipoVisitante(equipoVisitante);
                    partidos.add(partido);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return partidos;
    }
}
