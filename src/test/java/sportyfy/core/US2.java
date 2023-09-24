package sportyfy.core;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class US2 {


    static List<String> nombresPronosticadores;

    static List<String> nombresPronosticadoresVacia;

    static List<String> nombresPronosticadoresSinRuta;

    static IniciadorSportyfyCore iniciadorConPronosticadores;

    static IniciadorSportyfyCore iniciadorSinRuta;

    static IniciadorSportyfyCore iniciadorCarpetaVacia;


    @BeforeClass
    public static void Escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, FileNotFoundException {
        iniciadorConPronosticadores = new IniciadorSportyfyCore();
        iniciadorConPronosticadores.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pruebasPronosticadores");

        cargaDeOtrosIniciadores();
    }

    @Test
    public void CA1_EncuentraPronosticadores() {
        assertTrue(nombresPronosticadores.contains("PronosticadorFutbol"));
        assertTrue(nombresPronosticadores.contains("PronosticadorPrueba"));
        assertEquals(nombresPronosticadores.size(),2);

    }

    @Test
    public void CA2_ExtensionInvalida() {
        assertFalse(nombresPronosticadores.contains("ExtensionInvalidaPronosticador"));
    }

    @Test
    public void CA3_EncuentraJarNoEsPronosticador() {
        assertFalse(nombresPronosticadores.contains("NoEsPronosticador"));
    }

    @Test (expected = FileNotFoundException.class)
    public void CA4_CarpetaInvalida() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        iniciadorSinRuta = new IniciadorSportyfyCore();
        iniciadorSinRuta.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/p");
    }

    @Test
    public void CA5_CarpetaVacia() {
        assertTrue(nombresPronosticadoresVacia.isEmpty());
    }

    private static void cargaDeOtrosIniciadores() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, FileNotFoundException {

        iniciadorCarpetaVacia = new IniciadorSportyfyCore();
        iniciadorCarpetaVacia.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pruebasPronosticadoresVacia");


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

        /*nombresPronosticadoresSinRuta = iniciadorSinRuta.getBuscadorPronosticadores()
                .getPronosticadores()
                .stream()
                .map(pronosticador -> pronosticador.getClass().getSimpleName())
                .collect(Collectors.toList());*/
    }
}