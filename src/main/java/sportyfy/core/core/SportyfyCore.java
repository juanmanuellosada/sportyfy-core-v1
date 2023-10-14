package sportyfy.core.core;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.Pronostico;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.entidades.partido.PartidoJugado;

import java.util.List;
import java.util.Observable;
import java.util.Set;

/**
 * La clase SportyfyCore representa el núcleo del sistema Sportyfy. Contiene información sobre pronosticadores,
 * equipos, partidos jugados y el pronóstico actual. Esta clase también proporciona la funcionalidad de
 * pronosticar partidos futuros y notificar a los observadores cuando cambia el pronóstico actual.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("deprecation")
public class SportyfyCore extends Observable {

    private Set<Pronosticador> pronosticadores;
    private Pronostico pronosticoActual;
    private List<Equipo> equipos;
    private List<PartidoJugado> partidosJugados;

    /**
     * Construye una instancia de SportyfyCore.
     *
     * @param pronosticadores  Conjunto de pronosticadores disponibles en el sistema.
     * @param equipos          Lista de equipos disponibles en el sistema.
     * @param partidosJugados  Lista de partidos jugados en el sistema.
     */
    public SportyfyCore(Set<Pronosticador> pronosticadores, List<Equipo> equipos, List<PartidoJugado> partidosJugados) {
        this.pronosticadores = pronosticadores;
        this.equipos = equipos;
        this.partidosJugados = partidosJugados;
    }

    /**
     * Realiza un pronóstico para un partido futuro utilizando el pronosticador especificado.
     *
     * @param partidoFuturo        Partido futuro para el que se desea realizar el pronóstico.
     * @param nombrePronosticador  Nombre del pronosticador que realizará el pronóstico.
     * @throws IllegalArgumentException Si no se encuentra el pronosticador especificado.
     */
    public void pronosticar(PartidoFuturo partidoFuturo, String nombrePronosticador) {
        Pronosticador pronosticador = new BuscadorPronosticadores().buscarPronosticador(pronosticadores, nombrePronosticador);
        if (pronosticador == null) throw new IllegalArgumentException("No se encontró el pronosticador");

        setPronosticoActual(pronosticador.pronosticar(partidoFuturo, partidosJugados));

        setChanged();
        notifyObservers();
    }
}
