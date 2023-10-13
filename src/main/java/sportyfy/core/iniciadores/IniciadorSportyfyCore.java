package sportyfy.core.iniciadores;

import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.SelectorPronosticadores;
import sportyfy.core.entidades.partido.PartidoJugado;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class IniciadorSportyfyCore {

    private final String rutaArchivoEquipos;
    private final String rutaCarpetaPartidosJugados;

    public IniciadorSportyfyCore() throws IOException {
        this.rutaArchivoEquipos = leerProperties("rutaArchivoEquipos");
        this.rutaCarpetaPartidosJugados = leerProperties("rutaCarpetaPartidosJugados");
    }
    public SportyfyCore iniciar(String rutaPronosticadores) throws IOException {
        List<Equipo> equipos = (List<Equipo>) IniciadorEquiposPartidos.iniciar(rutaArchivoEquipos, rutaCarpetaPartidosJugados, null, IniciadorEquiposPartidos.TipoInicializacion.EQUIPOS);
        List<PartidoJugado> partidoJugados = (List<PartidoJugado>) IniciadorEquiposPartidos.iniciar(rutaArchivoEquipos, rutaCarpetaPartidosJugados, equipos, IniciadorEquiposPartidos.TipoInicializacion.PARTIDOS);

        Set<Pronosticador> pronosticadores = new BuscadorPronosticadores().buscarPronosticadores(rutaPronosticadores);

        //Pronosticador pronosticadorFutbol = new SelectorPronosticadores(pronosticadores).seleccionarPronosticador(pronosticadores.stream().findFirst().get().getClass().getSimpleName());

        //return new SportyfyCore(pronosticadorFutbol, equipos, partidoJugados);
        return new SportyfyCore(pronosticadores, equipos, partidoJugados);

    }

    public String leerProperties(String propertie) throws IOException {
        Properties prop = new Properties();

        FileInputStream input = new FileInputStream("src/main/resources/rutas.properties");
        prop.load(input);

        return prop.getProperty(propertie);
    }

}