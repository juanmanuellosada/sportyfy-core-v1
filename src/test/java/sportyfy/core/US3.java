package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US3 {
/*
      private static IniciadorSportyfyCore iniciador;
      private static SportyfyCore sportyfyCorePronosticadores;
      private static Set<Pronosticador> pronosticadoresPorDefecto;
      private static Pronostico pronosticoFutbol;
      private static Pronostico pronosticoFutbolCaraACara;
      private static List<String> nombresPronosticadores;

      @BeforeAll
      public static void escenario() throws IOException {
            iniciador = new IniciadorSportyfyCore(false);
            cargarPronosticadoresPorDefecto();
      }


      @Test
      @Order(1)
      @DisplayName("Pronosticadores por defecto de SportyfyCore al inicializarse")
      public void CA1_pronosticadoresSportyfyCore() {
            List<String> nombresPronosticadoresEsperados = new ArrayList<>();
            nombresPronosticadoresEsperados.add("PronosticadorFutbol");
            nombresPronosticadoresEsperados.add("PronosticadorFutbolCaraACara");
            assertEquals(2, pronosticadoresPorDefecto.size());
            assertTrue(nombresPronosticadores.containsAll(nombresPronosticadoresEsperados));
      }

      @Test
      @Order(2)
      @DisplayName("Mismo partido a pronosticar, diferentes Pronosticos")
      public void CA2_diferentesPronosticosMismoPartido() {
            Equipo river = obtenerEquipo("River Plate");
            Equipo talleres = obtenerEquipo("Talleres Cordoba");
            PartidoFuturo partido = new PartidoFuturo(river, talleres);
            cargarPronosticos(partido);
            assertEquals(river, pronosticoFutbol.getEquipoGanador());
            assertEquals(talleres, pronosticoFutbolCaraACara.getEquipoGanador());
      }

      @Test
      @Order(3)
      @DisplayName("Se agrega pronosticador a SportyfyCore")
      public void CA3_AgregarPronosticador() throws IOException {
            sportyfyCorePronosticadores = iniciador.iniciar("src/test/java/carpetaDePruebaUS3/pronosticadoresConUnoNuevo");
            Set<Pronosticador> pronosticadores = sportyfyCorePronosticadores.getPronosticadores();
            List<String> nombresPronosticadores = sportyfyCorePronosticadores.obtenerNombresPronosticadores(pronosticadores);
            assertEquals(3, pronosticadores.size());
            assertTrue(nombresPronosticadores.contains("PronosticadorNuevo"));
      }

      public static void cargarPronosticadoresPorDefecto() throws IOException {
            sportyfyCorePronosticadores = iniciador.iniciar("src/test/java/carpetaDePruebaUS3/pronosticadoresPorDefecto");
            pronosticadoresPorDefecto = sportyfyCorePronosticadores.getPronosticadores();
            nombresPronosticadores =sportyfyCorePronosticadores.obtenerNombresPronosticadores(pronosticadoresPorDefecto);
      }

      public Equipo obtenerEquipo(String nombre) {
            return sportyfyCorePronosticadores.getEquipos().stream()
                    .filter(equipo -> equipo.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);
      }

      public void cargarPronosticos(PartidoFuturo partido) {
            sportyfyCorePronosticadores.pronosticar(partido, "PronosticadorFutbol");
            pronosticoFutbol = sportyfyCorePronosticadores.getPronosticoActual();
            sportyfyCorePronosticadores.pronosticar(partido,"PronosticadorFutbolCaraACara");
            pronosticoFutbolCaraACara =sportyfyCorePronosticadores.getPronosticoActual();
      }*/
}
