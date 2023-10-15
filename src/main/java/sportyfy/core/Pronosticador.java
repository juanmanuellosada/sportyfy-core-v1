package sportyfy.core;

import java.util.List;

import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.entidades.partido.PartidoJugado;

/**
 * Clase que representa un pronosticador
 */
public interface Pronosticador {

    /**
     * Pronostica un partido futuro
     * @param partidoFuturo Partido futuro a pronosticar
     * @param partidosJugados Partidos jugados hasta el momento
     * @return Pronóstico del partido
     */
    public Pronostico pronosticar(PartidoFuturo partidoFuturo, List<PartidoJugado> partidosJugados);

    /**
     * Obtiene el nombre del pronosticador
     * @return Nombre del pronosticador
     */
    public String obtenerDeporte();
}
