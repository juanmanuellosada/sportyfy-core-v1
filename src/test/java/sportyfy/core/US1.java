package sportyfy.core;


import org.junit.jupiter.api.*;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US1 {

    private static Equipo GimnasiaDeLaPlata;
    private static Equipo RiverPlate;
    private static Pronosticador pronosticador;
    private static Pronostico pronosticoEfectivo;
    private static Pronostico pronosticoEmpate;
    private static List<Partido> partidos;
    private static Equipo equipoSinPartidos;
    private static Pronostico pronosticoEquipoSinPartidos;
    private static List<Partido> partidosVacios;
    private static Pronostico pronosticoPartidosVacios;

    @BeforeAll
    public static void Escenario() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException {
        IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
        iniciador.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
        GimnasiaDeLaPlata = iniciador.getEquipos().get(0);
        RiverPlate = iniciador.getEquipos().get(1);
        pronosticador = iniciador.getBuscadorPronosticadores().getPronosticadores().iterator().next();
        partidos = iniciador.getPartidos();

        inicializacionCamposParaTest();

    }

    @Test
    @Order(1)
    @DisplayName("CA1 - Pronostico efectivo del partido. (hay inclinacion a favor de un equipo)")
    public void CA1_PronosticoEfectivoDePartido() {
        assertTrue(pronosticoEfectivo.getEquipoGanador().getNombre().equals("River Plate"));
    }

    @Test
    @Order(2)
    @DisplayName("CA2 - Pronostico de empate para un partido")
    public void CA2_PronosticoEmpate() {
        assertTrue(pronosticoEmpate.getEquipoGanador()==null);
    }

    @Test
    @Order(3)
    @DisplayName("CA3 - No se encuentra partidos de algun equipo(gana el otro equipo con partidos)")
    public void CA3_NoSeEncuentranPartidosDeEquipo() {
        assertEquals(pronosticoEquipoSinPartidos.getEquipoGanador(), GimnasiaDeLaPlata);
    }

   @Test
   @Order(4)
   @DisplayName("CA4 - No existe informacion sobre los partidos(RuntimeException)")
    public void CA4_NoHayInfoDePartidos() {
       partidosVacios = new ArrayList<Partido>();
       assertThrows(RuntimeException.class, ()->{
           pronosticoPartidosVacios = pronosticador.pronosticar(GimnasiaDeLaPlata, RiverPlate,partidosVacios);
       });
    }

    private static void inicializacionCamposParaTest(){

        // pronosticos//
        pronosticoEfectivo = pronosticador.pronosticar(GimnasiaDeLaPlata, RiverPlate,partidos);
        pronosticoEmpate = pronosticador.pronosticar(GimnasiaDeLaPlata, GimnasiaDeLaPlata,partidos);

        //Equipo sin partidos
        equipoSinPartidos = new Equipo();
        equipoSinPartidos.setNombre("EquipoSinPartidos");

        //pronostico donde un equipo no tiene partidos (gana el otro)
        pronosticoEquipoSinPartidos = pronosticador.pronosticar(GimnasiaDeLaPlata,equipoSinPartidos,partidos);
    }

}
