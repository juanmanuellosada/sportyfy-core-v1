package sportyfy.core;

import org.junit.BeforeClass;
import org.junit.Test;
import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.Assert.*;

public class HU1 {

    private static Equipo local;
    private static Equipo visitante;
    private static Pronosticador pronosticadorEfectivo;
    private static Pronosticador pronosticadorEmpate;
    private static List<Partido> partidos;

    @BeforeClass
    public static void Escenario() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        IniciadorSportyfyCore iniciador= new IniciadorSportyfyCore();
        iniciador.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pronosticadores");
        local=iniciador.getEquipos().get(0);
        visitante=iniciador.getEquipos().get(1);
        pronosticadorEfectivo =iniciador.getBuscadorPronosticadores().getPronosticadores().iterator().next();
        pronosticadorEmpate =iniciador.getBuscadorPronosticadores().getPronosticadores().iterator().next();
        partidos=iniciador.getPartidos();
    }

    @Test
    public void CA1_PronosticoEfectivoDePartido(){
        Pronostico pronostico= pronosticadorEfectivo.pronosticar(local,visitante,partidos);
        assertTrue(pronostico.getEquipoGanador() instanceof Equipo);
    }

    @Test
    public void CA2_PronosticoEmpate(){
        Pronostico pronostico= pronosticadorEmpate.pronosticar(local,local,partidos);
        assertNull(pronostico.getEquipoGanador());
    }
    @Test
    public void MainTieneSaludo() {
        IniciadorSportyfyCore main = new IniciadorSportyfyCore();
        assert main.saludar().equals("¡Hola mundo!");
    }

    @Test
    public void SegundoTestPrueba() {
        assertEquals(2, 2);
    }
}
