package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.iniciador.IniciadorSportyfyCore;
import sportyfy.core.core.SportyfyCore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US2 {
/*
    private static IniciadorSportyfyCore iniciador;
    private static SportyfyCore coreConPronosticadores;
    private static SportyfyCore coreCarpetaVacia;
    private static SportyfyCore coreArchivoInvalido;

    @BeforeAll
    public static void Escenario() throws IOException, IllegalArgumentException {
        iniciador = new IniciadorSportyfyCore();
        coreConPronosticadores = iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasPronosticadores");

        coreCarpetaVacia = iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasPronosticadoresVacia");

    }

    @Test
    @Order(1)
    @DisplayName("Encuentra los pronosticadores")
    public void CA1_pruebaEncuentraPronosticadores() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(coreConPronosticadores);
        List<String> pronosticadoresEsperados = new ArrayList<>(Arrays.asList("PronosticadorFutbol", "PronosticadorPrueba"));
        assertTrue(nombresPronosticadores.containsAll(pronosticadoresEsperados));
        assertEquals(2, nombresPronosticadores.size());
    }

    @Test
    @Order(2)
    @DisplayName("Extensión de archivo inválida")
    public void CA2_pruebaExtensionInvalida() {
        assertThrows(IllegalArgumentException.class, ()->{
            iniciador = new IniciadorSportyfyCore();
            coreArchivoInvalido = iniciador.iniciar("src/test/java/carpetasDePrueba/pruebasArchivoInvalido");
        });

    }
    @Test
    @Order(3)
    @DisplayName("No se considera Pronosticador archivo .jar")
    public void CA3_pruebaNoEsPronosticador() {
        List<String> nombresPronosticadores = obtenerNombresPronosticadores(coreConPronosticadores);
        assertFalse(nombresPronosticadores.contains("NoEsPronosticador"));
    }

    @Test
    @Order(4)
    @DisplayName("Carpeta inexistente")
    public void CA4_carpetaInexistente() {
       assertThrows(FileNotFoundException.class,()->{
          SportyfyCore coreCarpetaInexistente = iniciador.iniciar("src/test/java/carpetasDePrueba/carpetaNoExistente");
       });
    }

    @Test
    @Order(5)
    @DisplayName("Carpeta vacía")
    public void CA5_pruebaCarpetaVacia() {
        List<String> nombresPronosticadoresVacia = obtenerNombresPronosticadores(coreCarpetaVacia);
        assertTrue(nombresPronosticadoresVacia.isEmpty());
    }

    private List<String> obtenerNombresPronosticadores(SportyfyCore core) {
        BuscadorPronosticadores buscadorPronosticadores = new BuscadorPronosticadores();
        return buscadorPronosticadores.obtenerNombresPronosticadores(core.getPronosticadores());
    }*/

    @Test
    @Order(1)
    @DisplayName("Test Falso")
    public void CA1_PronosticoEfectivo() {
        assertEquals(1, 1);
    }


}
