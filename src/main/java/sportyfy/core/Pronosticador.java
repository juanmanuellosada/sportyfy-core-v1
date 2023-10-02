package sportyfy.core;

import java.util.List;

import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.Partido;

public interface Pronosticador {
    public Pronostico pronosticar(Equipo equipoLocal, Equipo equipoVisitante, List<Partido> partidosAnteriores);

    public String obtenerDeporte();
}
