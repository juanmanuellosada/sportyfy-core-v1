package sportyfy.core.iniciador;

import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.constructores.LectorJson;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.constructores.ConstructorEquipos;
import sportyfy.core.constructores.ConstructorPartidos;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.PartidoAnterior;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class IniciadorSportyfyCore {

    public SportyfyCore iniciar(String rutaPronosticadores) throws IOException {

        String rutaArchivoEquipos = leerProperties("rutaArchivoEquipos");
        String rutaCarpetaPartidos = leerProperties("rutaCarpetaPartidos");


        // Armando equipos
        ConstructorEquipos constructorEquipos = new ConstructorEquipos();
        LectorJson lectorJson = new LectorJson();
        List<Equipo> equipos = constructorEquipos.crearEquipos(lectorJson.leerArchivoJson(rutaArchivoEquipos));

        //Armando partidos
        ConstructorPartidos constructorPartidos = new ConstructorPartidos();
        List<PartidoAnterior> partidosAnteriores = constructorPartidos.crearPartidos(lectorJson.leerArchivosJson(rutaCarpetaPartidos), equipos);

        BuscadorPronosticadores buscadorPronosticadores = new BuscadorPronosticadores();

        Set<Pronosticador> pronosticadores = buscadorPronosticadores.buscarPronosticadores(rutaPronosticadores);

        return new SportyfyCore(pronosticadores, equipos, partidosAnteriores);
    }

    public String leerProperties(String propertie) throws IOException {
        Properties prop = new Properties();

        FileInputStream input = new FileInputStream("src/main/resources/rutas.properties");
        prop.load(input);

        return prop.getProperty(propertie);
    }

}