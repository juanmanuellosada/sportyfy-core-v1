package sportyfy.core.core;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sportyfy.core.Pronosticador;
import sportyfy.core.Pronostico;
import sportyfy.core.PronosticoParaHistorial;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.entidades.partido.PartidoJugado;

import java.util.List;
import java.util.Observable;

@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("deprecation")
public class SportyfyCore extends Observable {

    private Pronosticador pronosticador;
    private Pronostico pronosticoActual;
    private PronosticoParaHistorial pronosticoActualParaHistorial;
    private List<Equipo> equipos;
    private List<PartidoJugado> partidosJugados;

    /* Puedo contruir el modelo sin tener pronóstico actual */
    public SportyfyCore(Pronosticador pronosticador, List<Equipo> equipos, List<PartidoJugado> partidosJugados) {
        this.pronosticador = pronosticador;
        this.equipos = equipos;
        this.partidosJugados = partidosJugados;
    }

    public void pronosticar(PartidoFuturo partidoFuturo, List<PartidoJugado> partidosJugados) {
        pronosticoActual = pronosticador.pronosticar(partidoFuturo, partidosJugados);
        setChanged();
        notifyObservers();
    }

    public void pronosticarParaHistorial(PartidoFuturo partidoFuturo, List<PartidoJugado> partidosJugados) {
        pronosticoActualParaHistorial.setEquipoGanador(pronosticador.pronosticar(partidoFuturo, partidosJugados).getEquipoGanador());
        pronosticoActualParaHistorial.setEquipoLocal(partidoFuturo.getEquipoLocal());
        pronosticoActualParaHistorial.setEquipoVisitante(partidoFuturo.getEquipoVisitante());
        setChanged();
        notifyObservers();
    }




}
