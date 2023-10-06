package sportyfy.core.iniciador;

import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.constructores.ConstructorEquipos;
import sportyfy.core.constructores.ConstructorPartidos;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.Partido;

import java.io.FileNotFoundException;
import java.util.List;

public class IniciadorSportyfyCore {

    public SportyfyCore iniciar(String rutaArchivoEquipos, String rutaCarpetaPartidos, String rutaPronosticadores) throws FileNotFoundException,IllegalArgumentException {
        ConstructorEquipos constructorEquipos = new ConstructorEquipos();
        List<Equipo> equipos = constructorEquipos.crearEquipos(rutaArchivoEquipos);

        ConstructorPartidos constructorPartidos = new ConstructorPartidos();
        List<Partido> partidos = constructorPartidos.crearPartidos(rutaCarpetaPartidos, equipos);

        BuscadorPronosticadores buscadorPronosticadores = new BuscadorPronosticadores(rutaPronosticadores);

        return new SportyfyCore(buscadorPronosticadores, equipos, partidos);
    }

}