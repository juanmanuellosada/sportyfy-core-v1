package sportyfy.core;

/**
 * Clase que representa un pronóstico nulo, es decir, un pronóstico en caso de empate. Porque este no tiene ganador.
 */
public class PronosticoNull extends Pronostico {
    public PronosticoNull() {
        super(null);
    }
}
