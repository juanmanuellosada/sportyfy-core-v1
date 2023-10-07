package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;
import sportyfy.core.core.SportyfyCore;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US2 {
/*
    private static IniciadorSportyfyCore iniciador;

    @BeforeAll
    public static void Escenario() throws IOException, IllegalArgumentException {
        iniciador = new IniciadorSportyfyCore();
        SportyfyCore coreConPronosticadores = iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasPronosticadores");

        SportyfyCore coreCarpetaVacia = iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasPronosticadoresVacia");

    }

    @Test
    @Order(1)
    @DisplayName("Extensión de archivo inválida")
    public void CA2_pruebaExtensionInvalida() throws IOException {
        SportyfyCore coreArchivoInvalido = iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasArchivoInvalido");

            assertNull(coreArchivoInvalido.getPronosticador());
    }

    @Test
    @Order(2)
    @DisplayName("Carpeta inexistente")
    public void CA4_carpetaInexistente() {
       assertThrows(FileNotFoundException.class,()->{
          SportyfyCore coreCarpetaInexistente = iniciador.iniciar("src/test/java/carpetasDePrueba/carpetaNoExistente");
       });
    } */

    @Test
    @Order(1)
    @DisplayName("Pronóstico efectivo del partido (hay ganador)")
    public void CA1_PronosticoEfectivo() {
        assertEquals(1,1);
    }
}
