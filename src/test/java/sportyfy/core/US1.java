package sportyfy.core;

import org.junit.jupiter.api.*;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.PartidoAnterior;
import sportyfy.core.iniciador.IniciadorSportyfyCore;
import sportyfy.core.core.SportyfyCore;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US1 {

      private static Equipo GimnasiaDeLaPlata;
      private static Equipo RiverPlate;
      private static Pronosticador pronosticador;
      private static Pronostico pronosticoEfectivo;
      private static Pronostico pronosticoEmpate;
      private static Pronostico pronosticoEquipoSinPartidos;

      @BeforeAll
      public static void Escenario() throws IOException, IllegalArgumentException {
            IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
            SportyfyCore core = iniciador.iniciar("src/pronosticadores");
            GimnasiaDeLaPlata = core.getEquipos().get(0);
            RiverPlate = core.getEquipos().get(1);
            pronosticador = core.getPronosticadores().iterator().next();
            List<PartidoAnterior> partidosAnteriores = core.getPartidosAnteriores();

            // Pronósticos
            pronosticoEfectivo = pronosticador.pronosticar(GimnasiaDeLaPlata, RiverPlate,
                    partidosAnteriores);
            pronosticoEmpate = pronosticador.pronosticar(GimnasiaDeLaPlata,
                        GimnasiaDeLaPlata, partidosAnteriores);

            // Equipo sin partidos
            Equipo equipoSinPartidos = new Equipo();
            equipoSinPartidos.setNombre("EquipoSinPartidos");

            // Pronóstico donde un equipo no tiene partidos (gana el otro)
            pronosticoEquipoSinPartidos = pronosticador.pronosticar(GimnasiaDeLaPlata,
                    equipoSinPartidos, partidosAnteriores);
      }

      @Test
      @Order(1)
      @DisplayName("Pronóstico efectivo del partido (hay ganador)")
      public void CA1_PronosticoEfectivo() {
            assertEquals("River Plate", pronosticoEfectivo.getEquipoGanador().getNombre());
      }

      @Test
      @Order(2)
      @DisplayName("Pronóstico de empate para el partido (devuelve un PronosticoNull) ")
      public void CA2_PronosticoEmpate() {
            assertEquals(pronosticoEmpate.getClass(),PronosticoNull.class);
      }

      @Test
      @Order(3)
      @DisplayName("No se encuentran partidos de equipo (gana el otro equipo con partidos)")
      public void CA3_NoSeEncuentranPartidosDeEquipo() {
            assertEquals(GimnasiaDeLaPlata,
                        pronosticoEquipoSinPartidos.getEquipoGanador());
      }

      @Test
      @Order(4)
      @DisplayName("No existe información sobre los partidos (RuntimeException)")
      public void CA4_NoHayInfoDePartidos() {
            List<PartidoAnterior> partidosVacios = new ArrayList<>();
            assertThrows(RuntimeException.class, () -> {
                  Pronostico pronosticoPartidosVacios = pronosticador.pronosticar(GimnasiaDeLaPlata, RiverPlate,
                              partidosVacios);
            });
      }

}