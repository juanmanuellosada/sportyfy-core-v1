package sportyfy.core.iniciadores;

import sportyfy.apiFootball.GeneradorJsons;
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
import java.util.concurrent.CountDownLatch;

public class IniciadorSportyfyCore {

    private final String rutaCarpetaEquipos;
    private final String rutaCarpetaPartidosJugados;

    public IniciadorSportyfyCore() throws IOException {
        this.rutaCarpetaEquipos = leerProperties("rutaCarpetaEquipos");
        this.rutaCarpetaPartidosJugados = leerProperties("rutaCarpetaPartidosJugados");
        //Genero los jsons de los equipos y los partidos
        GeneradorJsons.generarJsonEquipos(rutaCarpetaEquipos);
        GeneradorJsons.generarJsonsPartidos(rutaCarpetaPartidosJugados);
    }

    // Agrego el SuppressWarnings por el casteo del método iniciar
    @SuppressWarnings("unchecked")
    public SportyfyCore iniciar(String rutaPronosticadores) throws IOException {
        List<Equipo> equipos = (List<Equipo>) IniciadorEquiposPartidos.iniciar(rutaCarpetaEquipos + "/equipos.json",
                rutaCarpetaPartidosJugados, null, IniciadorEquiposPartidos.TipoInicializacion.EQUIPOS);

        List<PartidoJugado> partidoJugados = (List<PartidoJugado>) IniciadorEquiposPartidos.iniciar(rutaCarpetaEquipos,
                rutaCarpetaPartidosJugados, equipos, IniciadorEquiposPartidos.TipoInicializacion.PARTIDOS);

        Set<Pronosticador> pronosticadores = new BuscadorPronosticadores().buscarPronosticadores(rutaPronosticadores);

        return new SportyfyCore(pronosticadores, equipos, partidoJugados);
    }

    public String leerProperties(String propertie) throws IOException {
        Properties prop = new Properties();

        FileInputStream input = new FileInputStream("src/main/resources/rutas.properties");
        prop.load(input);

        return prop.getProperty(propertie);
    }

}