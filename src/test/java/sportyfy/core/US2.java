package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;
import sportyfy.core.core.SportyfyCore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US2 {

    private static IniciadorSportyfyCore iniciador;

    @BeforeAll
    public static void escenario() throws IOException {
        iniciador = new IniciadorSportyfyCore();
    }

    @Test
    @Order(1)
    @DisplayName("Carpeta con un Pronosticador válido")
    public void CA1_CarpetaConPronosticadorValido() throws IOException {
        SportyfyCore core = iniciador.iniciar("src/test/java/carpetasDePrueba/pronosticadorFutbol");
        assertNotNull(core.getPronosticadores().iterator().next());
    }

    @Test
    @Order(2)
    @DisplayName("Carpeta vacía")
    public void CA2_CarpetaVacia() {
        assertThrows(NoSuchElementException.class, () -> {
            iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasPronosticadoresVacia");
        });
    }

    @Test
    @Order(3)
    @DisplayName("Carpeta con archivo de extensión inválida (no es JAR)")
    public void CA3_CarpetaConArchivosNoJAR() {
        assertThrows(IllegalArgumentException.class, () -> {
            iniciador.iniciar("src/test/java/carpetasDePrueba/ArchivoInvalido");
        });
    }

    @Test
    @Order(4)
    @DisplayName("Carpeta con JAR pero no es Pronosticador")
    public void CA4_CarpetaConJARNoPronosticador() {
        assertThrows(NoSuchElementException.class, () -> {
            iniciador.iniciar("src/test/java/carpetasDePrueba/JARNoPronosticador");
        });
    }

    @Test
    @Order(5)
    @DisplayName("Carpeta inexistente")
    public void CA5_CarpetaNoExiste() {
        assertThrows(FileNotFoundException.class, () -> {
            iniciador.iniciar("src/test/java/carpetasDePrueba/carpetaInexistente");
        });
    }
}
