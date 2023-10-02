package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.iniciador.IniciadorSportyfyCore;
import sportyfy.core.modelo.SportyfyCore;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US2 {

    private static IniciadorSportyfyCore iniciadorConPronosticadores;
    private static IniciadorSportyfyCore iniciadorCarpetaVacia;

    private static SportyfyCore coreConPronosticadores;

    private static SportyfyCore coreCarpetaVacia;

    @BeforeAll
    public static void Escenario() {
        iniciadorConPronosticadores = new IniciadorSportyfyCore();
        coreConPronosticadores = iniciadorConPronosticadores.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/",
                "src/pruebasPronosticadores");

        iniciadorCarpetaVacia = new IniciadorSportyfyCore();
        coreCarpetaVacia = iniciadorCarpetaVacia.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/",
                "src/pruebasPronosticadoresVacia");

    }

    @Test
    @Order(1)
    @DisplayName("Encuentra los Pronosticadores")
    public void pruebaEncuentraPronosticadores() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(coreConPronosticadores);
        assertTrue(nombresPronosticadores.contains("PronosticadorFutbol"));
        assertTrue(nombresPronosticadores.contains("PronosticadorPrueba"));
        assertEquals(2, nombresPronosticadores.size());
    }

    @Test
    @Order(2)
    @DisplayName("Extension de archivo invalida")
    public void pruebaExtensionInvalida() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(coreCarpetaVacia);
        assertFalse(nombresPronosticadores.contains("ExtensionInvalidaPronosticador"));
    }

    @Test
    @Order(3)
    @DisplayName("No se considera Pronosticador archivo .jar")
    public void pruebaNoEsPronosticador() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(coreConPronosticadores);
        assertFalse(nombresPronosticadores.contains("NoEsPronosticador"));
    }

    @Test
    @Order(4)
    @DisplayName("Carpeta vacia")
    public void pruebaCarpetaVacia() {
        List<String> nombresPronosticadoresVacia = obtenerNombresPronosticadores(coreCarpetaVacia);
        assertTrue(nombresPronosticadoresVacia.isEmpty());
    }

    private List<String> obtenerNombresPronosticadores(SportyfyCore core) {
        return core.getBuscadorPronosticadores()
                .obtenerNombresPronosticadores(core.getBuscadorPronosticadores().getPronosticadores());
    }


}
