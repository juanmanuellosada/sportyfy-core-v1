package sportyfy.core;


import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US2 {


    static List<String> nombresPronosticadores;

    static List<String> nombresPronosticadoresVacia;

    static List<String> nombresPronosticadoresSinRuta;

    static IniciadorSportyfyCore iniciadorConPronosticadores;

    static IniciadorSportyfyCore iniciadorSinRuta;

    static IniciadorSportyfyCore iniciadorCarpetaVacia;


    @BeforeAll
    public static void Escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, FileNotFoundException {
        iniciadorConPronosticadores = new IniciadorSportyfyCore();
        iniciadorConPronosticadores.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pruebasPronosticadores");

        cargaDeOtrosIniciadores();
    }

    @Test
    @Order(1)
    @DisplayName("CA1 - Encuentra los Pronosticadores")
    public void CA1_EncuentraPronosticadores() {
        assertTrue(nombresPronosticadores.contains("PronosticadorFutbol"));
        assertTrue(nombresPronosticadores.contains("PronosticadorPrueba"));
        assertEquals(nombresPronosticadores.size(),2);

    }

    @Test
    @Order(2)
    @DisplayName("CA2 - Extension de archivo invalida")
    public void CA2_ExtensionInvalida() {
        assertFalse(nombresPronosticadores.contains("ExtensionInvalidaPronosticador"));
    }

    @Test
    @Order(3)
    @DisplayName("CA3 - No se considera Pronosticador archivo .jar")
    public void CA3_EncuentraJarNoEsPronosticador() {
        assertFalse(nombresPronosticadores.contains("NoEsPronosticador"));
    }

    @Test
    @Order(4)
    @DisplayName("CA4 - Carpeta invalida")
    public void CA4_CarpetaInvalida() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        iniciadorSinRuta = new IniciadorSportyfyCore();
        assertThrows(FileNotFoundException.class, ()->{
            iniciadorSinRuta.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/p");

        });
    }

    @Test
    @Order(5)
    @DisplayName("CA5 - Carpeta vacia")
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
    }
}