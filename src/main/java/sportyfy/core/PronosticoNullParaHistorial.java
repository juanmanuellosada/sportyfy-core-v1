package sportyfy.core;
import sportyfy.core.entidades.equipo.Equipo;

public class PronosticoNullParaHistorial extends PronosticoParaHistorial {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Equipo equipoGanador;

    public PronosticoNullParaHistorial(Equipo equipoLocal, Equipo equipoVisitante, Equipo equipoGanador) {
        super(equipoLocal, equipoVisitante, null);
    }
}
