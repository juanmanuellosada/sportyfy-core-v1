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

    private IniciadorSportyfyCore iniciadorConPronosticadores;
    private IniciadorSportyfyCore iniciadorCarpetaVacia;

    @BeforeAll
    public static void Escenario() {
        // Configuración inicial
    }

    @Test
    @Order(1)
    @DisplayName("Encuentra los Pronosticadores")
    public void pruebaEncuentraPronosticadores() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(iniciadorConPronosticadores);
        assertTrue(nombresPronosticadores.contains("PronosticadorFutbol"));
        assertTrue(nombresPronosticadores.contains("PronosticadorPrueba"));
        assertEquals(2, nombresPronosticadores.size());
    }

    @Test
    @Order(2)
    @DisplayName("Extension de archivo invalida")
    public void pruebaExtensionInvalida() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(iniciadorConPronosticadores);
        assertFalse(nombresPronosticadores.contains("ExtensionInvalidaPronosticador"));
    }

    @Test
    @Order(3)
    @DisplayName("No se considera Pronosticador archivo .jar")
    public void pruebaNoEsPronosticador() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(iniciadorConPronosticadores);
        assertFalse(nombresPronosticadores.contains("NoEsPronosticador"));
    }

    @Test
    @Order(4)
    @DisplayName("Carpeta invalida")
    public void pruebaCarpetaInvalida() {
        assertThrows(FileNotFoundException.class, () -> {
            iniciarCoreConRutaInvalida();
        });
    }

    @Test
    @Order(5)
    @DisplayName("Carpeta vacia")
    public void pruebaCarpetaVacia() {
        List<String> nombresPronosticadoresVacia = obtenerNombresPronosticadores(iniciadorCarpetaVacia);
        assertTrue(nombresPronosticadoresVacia.isEmpty());
    }

    private List<String> obtenerNombresPronosticadores(IniciadorSportyfyCore iniciador) {
        SportyfyCore core = iniciador.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/pruebasPronosticadores");
        return core.getBuscadorPronosticadores().obtenerNombresPronosticadores(core.getBuscadorPronosticadores().getPronosticadores());
    }

    private void iniciarCoreConRutaInvalida() {
        IniciadorSportyfyCore iniciadorSinRuta = new IniciadorSportyfyCore();
        iniciadorSinRuta.iniciar("datosFutbol/equipos/equipos.json", "datosFutbol/ultimos_resultados/", "src/p");
    }
}
