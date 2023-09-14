package sportyfy.core.futbol;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Integer golesLocal;
    private Integer golesVisitante;

    public Equipo obtenerGanador() {
        return golesLocal > golesVisitante ? equipoLocal : golesLocal < golesVisitante ? equipoVisitante : null;
    }

    public Equipo obtenerPerdedor() {
        return golesLocal < golesVisitante ? equipoLocal : golesLocal > golesVisitante ? equipoVisitante : null;
    }

    public boolean esEmpate() {
        return golesLocal == golesVisitante;
    }

    public boolean esLocal(Equipo equipo) {
        return equipoLocal.equals(equipo);
    }

    public boolean esVisitante(Equipo equipo) {
        return equipoVisitante.equals(equipo);
    }

    public boolean participa(Equipo equipo) {
        return esLocal(equipo) || esVisitante(equipo);
    }
}