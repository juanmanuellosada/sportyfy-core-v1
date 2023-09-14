package sportyfy.core;

import lombok.Data;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Data
public class IniciadorSportyfyCore {

    private BuscadorPronosticadores buscadorPronosticadores;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public void iniciar(String rutaArchivoEquipos, String rutaCarpetaPartidos, String rutaPronosticadores) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        ConstructorEquipos constructorEquipos = new ConstructorEquipos();
        this.equipos = constructorEquipos.crearEquipos(rutaArchivoEquipos);

        ConstructorPartidos constructorPartidos = new ConstructorPartidos();
        this.partidos = constructorPartidos.crearPartidos(rutaCarpetaPartidos, equipos);

        this.buscadorPronosticadores = new BuscadorPronosticadores();
        buscadorPronosticadores.setPronosticadores(buscadorPronosticadores.buscarPronosticadores(rutaPronosticadores));

        for (Pronosticador pronosticador : buscadorPronosticadores.getPronosticadores()) {
            Pronostico pronostico = pronosticador.pronosticar(equipos.get(0), equipos.get(1), partidos);

            System.out.println("Pronóstico para " + pronosticador.getClass().getSimpleName() + ": " + pronostico.getEquipoGanador());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        IniciadorSportyfyCore iniciadorSportyfyCore = new IniciadorSportyfyCore();
        iniciadorSportyfyCore.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
    }

    // Dejo este método porque lo usa el test de ejemplo, pero no iría
    public String saludar() {
        return "¡Hola mundo!";
    }
}