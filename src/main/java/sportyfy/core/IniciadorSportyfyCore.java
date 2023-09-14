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

        this.buscadorPronosticadores = new BuscadorPronosticadores(rutaPronosticadores);

        /* Ejemplo de como se usaría el buscador de pronosticadores, no aplica. Solo está para ver si se podía pronosticar correctamente */
        for (Pronosticador pronosticador : buscadorPronosticadores.getPronosticadores()) {
            Pronostico pronostico = pronosticador.pronosticar(equipos.get(0), equipos.get(1), partidos);

            System.out.println("Pronóstico para " + pronosticador.getClass().getSimpleName() + ": " + "Equipo 1: " + equipos.get(0).getNombre() + " Equipo 2: " + equipos.get(1).getNombre() + " Resultado: Gana " + pronostico.getEquipoGanador());
        }
    }

    /* Este main es un ejemplo de como se vería el main de la UI, no aplica. Solo está para chequear el funcionamiento */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        IniciadorSportyfyCore iniciadorSportyfyCore = new IniciadorSportyfyCore();
        iniciadorSportyfyCore.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
    }

    // Dejo este método porque lo usa el test de ejemplo, pero no iría
    public String saludar() {
        return "¡Hola mundo!";
    }
}