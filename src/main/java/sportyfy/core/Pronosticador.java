package sportyfy.core;

import java.io.FileNotFoundException;
import java.util.List;

import sportyfy.core.futbol.Equipo;
import sportyfy.core.futbol.Partido;

public interface Pronosticador {
    public Pronostico pronosticar(Equipo equipoLocal, Equipo equipoVisitante, List<Partido> partidosAnteriores);

    public String obtenerDeporte();
}
