package sportyfy.core.iniciadores;

import sportyfy.apiFootball.GeneradorJsons;
import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.partido.PartidoJugado;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Clase que inicializa el núcleo de Sportyfy, generando JSONs de equipos y
 * partidos y buscando los pronosticadores.
 */
public class IniciadorSportyfyCore {

        private final String rutaCarpetaEquipos;
        private final String rutaCarpetaPartidosJugados;

        /**
         * Construye una instancia de IniciadorSportyfyCore. Al construirse, genera los
         * JSONs de equipos y partidos y los
         * busca en la carpeta especificada. Luego genera los equipos y partidos jugados
         * a partir de los JSONs.
         * @param generar Si se desea generar los JSONs. (Para que no se generen cada vez que se ejecuta el programa,
         *                para los tests no necesito generarlos siempre).
         *
         * @throws IOException Si ocurre un error al leer los archivos JSON.
         */
        public IniciadorSportyfyCore(boolean generar) throws IOException {
                this.rutaCarpetaEquipos = leerProperties("rutaCarpetaEquipos");
                this.rutaCarpetaPartidosJugados = leerProperties("rutaCarpetaPartidosJugados");
                if (generar) generarJsons();
        }

        private void generarJsons() {
                GeneradorJsons.generarJsonEquipos(rutaCarpetaEquipos);
                GeneradorJsons.generarJsonsPartidos(rutaCarpetaPartidosJugados);
        }

        /**
         * Inicializa el SportyfyCore, buscando los pronosticadores en la carpeta
         * especificada.
         *
         * @param rutaPronosticadores Ruta de la carpeta que contiene los
         *                            pronosticadores.
         * @return Instancia de SportyfyCore inicializada.
         * @throws IOException Si ocurre un error al leer los archivos JSON.
         */
        @SuppressWarnings("unchecked")
        public SportyfyCore iniciar(String rutaPronosticadores) throws IOException {
                List<Equipo> equipos = (List<Equipo>) IniciadorEquiposPartidos.iniciar(
                                rutaCarpetaEquipos + "/equipos.json",
                                rutaCarpetaPartidosJugados, null, IniciadorEquiposPartidos.TipoInicializacion.EQUIPOS);

                List<PartidoJugado> partidoJugados = (List<PartidoJugado>) IniciadorEquiposPartidos.iniciar(
                                rutaCarpetaEquipos,
                                rutaCarpetaPartidosJugados, equipos,
                                IniciadorEquiposPartidos.TipoInicializacion.PARTIDOS);

                Set<Pronosticador> pronosticadores = new BuscadorPronosticadores()
                                .buscarPronosticadores(rutaPronosticadores);

                return new SportyfyCore(pronosticadores, equipos, partidoJugados);
        }

        /**
         * Método para leer el archivo de propiedades, que contiene las rutas de los
         * archivos JSON.
         * 
         * @param propertie Nombre de la propiedad a leer.
         * @return Valor de la propiedad.
         * @throws IOException Si ocurre un error al leer el archivo.
         */
        public String leerProperties(String propertie) throws IOException {
                Properties prop = new Properties();

                FileInputStream input = new FileInputStream("src/main/resources/rutas.properties");
                prop.load(input);

                return prop.getProperty(propertie);
        }

}