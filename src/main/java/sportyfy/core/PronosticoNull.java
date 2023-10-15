package sportyfy.core;

/**
 * Clase que representa un pronóstico nulo, es decir, un pronóstico en caso de empate. Porque este no tiene ganador.
 */
import sportyfy.core.entidades.partido.PartidoFuturo;

public class PronosticoNull extends Pronostico {
    public PronosticoNull(PartidoFuturo partidoFuturo) {
        super(null, partidoFuturo);
    }
}
