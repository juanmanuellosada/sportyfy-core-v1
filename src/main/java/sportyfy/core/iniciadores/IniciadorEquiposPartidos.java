package sportyfy.core.iniciadores;

import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.parsers.EquiposParser;
import sportyfy.core.parsers.LectorJson;
import sportyfy.core.parsers.PartidosParser;

import java.io.IOException;
import java.util.List;

/**
 * Clase que inicializa los equipos y partidos a partir de archivos JSON.
 */
public class IniciadorEquiposPartidos {

    /**
     * Enumeración que representa los tipos de inicialización que se pueden realizar.
     */
    public enum TipoInicializacion {
        EQUIPOS,
        PARTIDOS
    }

    /**
     * Inicializa los equipos y partidos a partir de archivos JSON.
     *
     * @param rutaArchivoEquipos        Ruta del archivo JSON que contiene los equipos.
     * @param rutaCarpetaPartidosJugados Ruta de la carpeta que contiene los archivos JSON que contienen los partidos
     *                                  jugados.
     * @param equipos                   Lista de equipos a los que asignarle los partidos.
     * @param tipo                      Tipo de inicialización a realizar. Puede ser EQUIPOS o PARTIDOS.
     * @return Lista de objetos inicializados.
     * @throws IOException Si ocurre un error al leer los archivos JSON.
     */
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
