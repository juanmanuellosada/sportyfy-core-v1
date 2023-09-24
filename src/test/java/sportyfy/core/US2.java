package sportyfy.core;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class US2 {


    // Que no encuentre el pronosticador de futbol

    // Extension de archivo invalida

    // Ubicacion invalida

    // Sin pronosticadores

    // Caso feliz

    // Se encuentran multiples pronosticadores

    static List<String> nombresPronosticadores;

    static List<String> nombresPronosticadoresVacia;

    static List<String> nombresPronosticadoresSinRuta;

    static IniciadorSportyfyCore iniciadorConPronosticadores;

    static IniciadorSportyfyCore iniciadorSinRuta;

    static IniciadorSportyfyCore iniciadorCarpetaVacia;


    @BeforeClass
    public static void Escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        iniciadorConPronosticadores = new IniciadorSportyfyCore();
        iniciadorConPronosticadores.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pruebasPronosticadores");

        iniciadorCarpetaVacia = new IniciadorSportyfyCore();
        iniciadorCarpetaVacia.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pruebasPronosticadoresVacia");

        iniciadorSinRuta = new IniciadorSportyfyCore();
        iniciadorSinRuta.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/p");

        nombresPronosticadores = iniciadorConPronosticadores.getBuscadorPronosticadores()
                .getPronosticadores()
                .stream()
                .map(pronosticador -> pronosticador.getClass().getSimpleName())
                .collect(Collectors.toList());

        nombresPronosticadoresVacia = iniciadorCarpetaVacia.getBuscadorPronosticadores()
                .getPronosticadores()
                .stream()
                .map(pronosticador -> pronosticador.getClass().getSimpleName())
                .collect(Collectors.toList());

        nombresPronosticadoresSinRuta = iniciadorSinRuta.getBuscadorPronosticadores()
                .getPronosticadores()
                .stream()
                .map(pronosticador -> pronosticador.getClass().getSimpleName())
                .collect(Collectors.toList());
    }

    @Test
    public void CA1_EncuentraPronosticadores() {
        assertTrue(nombresPronosticadores.contains("PronosticadorFutbol"));
        assertTrue(nombresPronosticadores.contains("PronosticadorPrueba"));
        assertEquals(nombresPronosticadores.size(),2);

    }

    @Test
    public void CA2_ExtensionInvalida() {
        assertFalse(nombresPronosticadores.contains("hola"));
    }

    @Test
    public void CA3_EncuentraJarNoEsPronosticador() {
        assertFalse(nombresPronosticadores.contains("NoEsPronosticador"));
    }

    @Test
    public void CA4_CarpetaInvalida() {
        assertEquals(nombresPronosticadoresSinRuta.size(),0);
    }

    @Test
    public void CA5_CarpetaVacia() {
        assertEquals(nombresPronosticadoresVacia.size(),0);
    }
}