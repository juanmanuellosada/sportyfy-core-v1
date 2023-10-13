package sportyfy.core.iniciadores;

import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.parsers.EquiposParser;
import sportyfy.core.parsers.LectorJson;
import sportyfy.core.parsers.PartidosParser;

import java.io.IOException;
import java.util.List;

public class IniciadorEquiposPartidos {

    public enum TipoInicializacion {
        EQUIPOS,
        PARTIDOS
    }

    public static List<?> iniciar(String rutaArchivoEquipos, String rutaCarpetaPartidosJugados, List<Equipo> equipos,
            TipoInicializacion tipo) throws IOException {
        LectorJson lectorJson = new LectorJson();
        EquiposParser equiposParser = new EquiposParser();
        PartidosParser partidosParser = new PartidosParser();

        switch (tipo) {
            case EQUIPOS:
                String jsonEquipos = lectorJson.leerArchivoJson(rutaArchivoEquipos);
                return equiposParser.crearEquipos(jsonEquipos);

            case PARTIDOS:
                List<String> jsonsPartidosJugadosTotales = lectorJson.leerArchivosJson(rutaCarpetaPartidosJugados);
                return partidosParser.crearPartidos(jsonsPartidosJugadosTotales, equipos);

            default:
                throw new IllegalArgumentException("Tipo de inicialización no válido");
        }
    }
}
