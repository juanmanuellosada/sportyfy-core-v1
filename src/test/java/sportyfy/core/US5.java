package sportyfy.core;


import org.junit.jupiter.api.*;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;
import sportyfy.historial.Historial;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US5 {
    /*
    private Equipo riverPlate;
    private SportyfyCore sportyfyCore;
    private Historial historial;
    private PartidoFuturo partidoFuturo;

    @BeforeEach
    public void escenario() throws IllegalArgumentException, IOException {
        historial = new Historial();
        IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore(false);
        sportyfyCore = iniciador.iniciar("src/pronosticadores");

        Equipo gimnasiaDeLaPlata = sportyfyCore.getEquipos().get(0);
        riverPlate = sportyfyCore.getEquipos().get(1);

        partidoFuturo = new PartidoFuturo(gimnasiaDeLaPlata, riverPlate);
    }

    @Test
    @Order(1)
    @DisplayName("Se guarda un pronostico con equipo ganador en el historial")
    void CA1_AgregarPronosticoAlHistorial() {
        Pronostico pronostico = new Pronostico(riverPlate,partidoFuturo);
        sportyfyCore.setPronosticoActual(pronostico);
        historial.update(sportyfyCore,null);

        assertEquals(riverPlate,historial.getPronosticosRealizados().get(0).getEquipoGanador());
    }

    @Test
    @Order(2)
    @DisplayName("Se guarda un pronostico de empate en el historial")
    void CA2_AgregarPronosticoNullAlHistorial() {
        Pronostico pronostico = new Pronostico(null,partidoFuturo);
        sportyfyCore.setPronosticoActual(pronostico);
        historial.update(sportyfyCore,null);

        assertNull(historial.getPronosticosRealizados().get(0).getEquipoGanador());
    }*/
}
