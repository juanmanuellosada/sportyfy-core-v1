package sportyfy.core;

import java.util.List;

import sportyfy.core.Pronostico;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.entidades.partido.PartidoJugado;

public interface Pronosticador {
    public Pronostico pronosticar(PartidoFuturo partidoFuturo, List<PartidoJugado> partidosJugados);

    public String obtenerDeporte();
}
