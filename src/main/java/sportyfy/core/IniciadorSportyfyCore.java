package sportyfy.core;

import lombok.Data;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Data
public class IniciadorSportyfyCore {

    private BuscadorPronosticadores buscadorPronosticadores;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public void iniciar(String rutaArchivoEquipos, String rutaCarpetaPartidos, String rutaPronosticadores) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException {
        ConstructorEquipos constructorEquipos = new ConstructorEquipos();
        this.equipos = constructorEquipos.crearEquipos(rutaArchivoEquipos);

        ConstructorPartidos constructorPartidos = new ConstructorPartidos();
        this.partidos = constructorPartidos.crearPartidos(rutaCarpetaPartidos, equipos);

        this.buscadorPronosticadores = new BuscadorPronosticadores(rutaPronosticadores);

    }

}