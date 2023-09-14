package sportyfy.core;

import org.junit.BeforeClass;
import org.junit.Test;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HU1 {

    private static Equipo local;
    private static Equipo visitante;
    private static Pronosticador pronosticador;
    private static Pronostico pronosticoEfectivo;
    private static Pronostico pronosticoEmpate;
    private static List<Partido> partidos;
    private static Equipo equipoSinPartidos;
    private static Pronostico pronosticoEquipoSinPartidos;
    private static List<Partido> partidosVacios;
    private static Pronostico pronosticoPartidosVacios;

    @BeforeClass
    public static void Escenario() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
        iniciador.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
        local = iniciador.getEquipos().get(0);
        visitante = iniciador.getEquipos().get(1);
        pronosticador = iniciador.getBuscadorPronosticadores().getPronosticadores().iterator().next();
        partidos = iniciador.getPartidos();

        // pronosticos//
        pronosticoEfectivo = pronosticador.pronosticar(local,visitante,partidos);
        pronosticoEmpate = pronosticador.pronosticar(local,local,partidos);

         //Equipo sin partidos
        equipoSinPartidos = new Equipo();
        equipoSinPartidos.setNombre("EquipoSinPartidos");

        //pronostico donde un equipo no tiene partidos (gana el otro)
        pronosticoEquipoSinPartidos = pronosticador.pronosticar(local,equipoSinPartidos,partidos);

        //partidos vacios
        partidosVacios = new ArrayList<Partido>();
        pronosticoPartidosVacios = pronosticador.pronosticar(local,visitante,partidosVacios);

    }

    @Test
    public void CA1_PronosticoEfectivoDePartido() {
        assertTrue(pronosticoEfectivo.getEquipoGanador() instanceof Equipo);
    }

    @Test
    public void CA2_PronosticoEmpate() {
        assertNull(pronosticoEmpate.getEquipoGanador());
    }

    @Test
    public void CA3_NoSeEncuentranPartidosDeEquipo() {
        assertEquals(pronosticoEquipoSinPartidos.getEquipoGanador(),local);
    }

   @Test
    public void CA4_NoHayInfoDePartidos() {
        assertNull(pronosticoPartidosVacios.getEquipoGanador());
    }

}
