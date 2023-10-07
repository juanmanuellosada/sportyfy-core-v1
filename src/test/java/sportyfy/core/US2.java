package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;
import sportyfy.core.core.SportyfyCore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US2 {

    private static IniciadorSportyfyCore iniciador;

    @BeforeAll
    public static void Escenario() throws IOException {
        iniciador = new IniciadorSportyfyCore();
    }

    @Test
    @Order(1)
    @DisplayName("Carpeta con un solo archivo JAR válido")
    public void CA1_CarpetaConUnSoloArchivoJARValido() throws IOException {
        SportyfyCore core = iniciador.iniciar("src/test/java/carpetasDePrueba/pronosticadorFutbol");
        assertNotNull(core.getPronosticador());
    }

    @Test
    @Order(2)
    @DisplayName("Carpeta vacía")
    public void CA2_CarpetaVacia() {
        // Arrojaría NoSuchElementException porque no hay ningún pronosticador
        assertThrows(NoSuchElementException.class, () -> {
            SportyfyCore core = iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasPronosticadoresVacia");
        });
    }

    @Test
    @Order(3)
    @DisplayName("Carpeta con archivos no JAR")
    public void CA3_CarpetaConArchivosNoJAR() throws IOException {
        // Arrojaría NoSuchElementException porque no hay ningún pronosticador
        assertThrows(NoSuchElementException.class, () -> {
            SportyfyCore core = iniciador.iniciar("src/test/java/carpetasDePrueba/ArchivoInvalido");
        });
    }

    @Test
    @Order(4)
    @DisplayName("Carpeta con un archivo JAR inválido (sin Pronosticadores)")
    public void CA4_CarpetaConArchivoJARInvalido() throws IOException {
        // Arrojaría NoSuchElementException porque no hay ningún pronosticador
        assertThrows(NoSuchElementException.class, () -> {
            SportyfyCore core = iniciador.iniciar("src/test/java/carpetasDePrueba/JARNoPronosticador");
        });
    }

    @Test
    @Order(5)
    @DisplayName("Carpeta que no existe")
    public void CA5_CarpetaNoExiste() {
        assertThrows(FileNotFoundException.class, () -> {
            SportyfyCore core = iniciador.iniciar("src/test/java/carpetasDePrueba/carpetaInexistente");
        });
    }

}
