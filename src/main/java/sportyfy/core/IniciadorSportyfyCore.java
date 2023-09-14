package sportyfy.core;

import lombok.Data;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

import java.util.List;

@Data
public class IniciadorSportyfyCore {

    private BuscadorPronosticadores buscadorPronosticadores;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public void iniciar(String rutaArchivoEquipos, String rutaCarpetaPartidos, String rutaPronosticadores) {
        ConstructorEquipos constructorEquipos = new ConstructorEquipos();
        this.equipos = constructorEquipos.crearEquipos(rutaArchivoEquipos);

        ConstructorPartidos constructorPartidos = new ConstructorPartidos();
        this.partidos = constructorPartidos.crearPartidos(rutaCarpetaPartidos, equipos);

        this.buscadorPronosticadores = new BuscadorPronosticadores();
        this.buscadorPronosticadores.buscarPronosticadores(rutaPronosticadores);
    }

    // Dejo este método porque lo usa el test de ejemplo, pero no iría
    public String saludar() {
        return "¡Hola mundo!";
    }
}