package sportyfy.core;

import sportyfy.core.futbol.Equipo;

public interface Pronosticador {
    public Pronostico pronosticar(Equipo equipoLocal, Equipo equipoVisitante);
    public String obtenerDeporte();
}
