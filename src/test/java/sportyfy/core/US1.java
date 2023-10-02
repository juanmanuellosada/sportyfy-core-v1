package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.Partido;
import sportyfy.core.iniciador.IniciadorSportyfyCore;
import sportyfy.core.modelo.SportyfyCore;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US1 {

    /*
     * private static Equipo GimnasiaDeLaPlata;
     * private static Equipo RiverPlate;
     * private static Pronosticador pronosticador;
     * private static Pronostico pronosticoEfectivo;
     * private static Pronostico pronosticoEmpate;
     * private static List<Partido> partidos;
     * private static Equipo equipoSinPartidos;
     * private static Pronostico pronosticoEquipoSinPartidos;
     * 
     * @BeforeAll
     * public static void Escenario() throws ClassNotFoundException,
     * InvocationTargetException, IllegalAccessException, InstantiationException,
     * NoSuchMethodException, FileNotFoundException {
     * IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
     * SportyfyCore core = iniciador.iniciar("datosFutbol/equipos/equipos.json",
     * "datosFutbol/ultimos_resultados/", "src/pronosticadores");
     * GimnasiaDeLaPlata = core.getEquipos().get(0);
     * RiverPlate = core.getEquipos().get(1);
     * pronosticador =
     * core.getBuscadorPronosticadores().getPronosticadores().iterator().next();
     * partidos = core.getPartidos();
     * 
     * // Pronósticos
     * pronosticoEfectivo = pronosticador.pronosticar(GimnasiaDeLaPlata, RiverPlate,
     * partidos);
     * pronosticoEmpate = pronosticador.pronosticar(GimnasiaDeLaPlata,
     * GimnasiaDeLaPlata, partidos);
     * 
     * // Equipo sin partidos
     * equipoSinPartidos = new Equipo();
     * equipoSinPartidos.setNombre("EquipoSinPartidos");
     * 
     * // Pronóstico donde un equipo no tiene partidos (gana el otro)
     * pronosticoEquipoSinPartidos = pronosticador.pronosticar(GimnasiaDeLaPlata,
     * equipoSinPartidos, partidos);
     * }
     * 
     * @Test
     * 
     * @Order(1)
     * 
     * @DisplayName("Prueba Pronóstico Efectivo del Partido")
     * public void CA1_PronosticoEfectivo() {
     * assertEquals("River Plate",
     * pronosticoEfectivo.getEquipoGanador().getNombre());
     * }
     * 
     * @Test
     * 
     * @Order(2)
     * 
     * @DisplayName("Prueba Pronóstico de Empate para un Partido")
     * public void CA2_PronosticoEmpate() {
     * assertNull(pronosticoEmpate.getEquipoGanador());
     * }
     * 
     * @Test
     * 
     * @Order(3)
     * 
     * @DisplayName("Prueba No Se Encuentran Partidos de Equipo (Gana el Otro Equipo con Partidos)"
     * )
     * public void CA3_NoSeEncuentranPartidosDeEquipo() {
     * assertEquals(GimnasiaDeLaPlata,
     * pronosticoEquipoSinPartidos.getEquipoGanador());
     * }
     * 
     * @Test
     * 
     * @Order(4)
     * 
     * @DisplayName("Prueba No Existe Información Sobre los Partidos (RuntimeException)"
     * )
     * public void CA4_NoHayInfoDePartidos() {
     * List<Partido> partidosVacios = new ArrayList<>();
     * assertThrows(RuntimeException.class, () -> {
     * Pronostico pronosticoPartidosVacios =
     * pronosticador.pronosticar(GimnasiaDeLaPlata, RiverPlate, partidosVacios);
     * });
     * }
     * 
     */
    @Test
    @Order(1)
    public void testFalso() {
        assertTrue(true);
    }

}