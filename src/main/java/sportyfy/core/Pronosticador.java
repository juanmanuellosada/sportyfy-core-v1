package sportyfy.core;

import java.util.List;

import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.PartidoAnterior;

public interface Pronosticador {
    public Pronostico pronosticar(Equipo equipoLocal, Equipo equipoVisitante, List<PartidoAnterior> partidosAnteriores);

    public String obtenerDeporte();
}
