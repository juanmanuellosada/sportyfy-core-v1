package sportyfy.core.futbol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Integer golesLocal;
    private Integer golesVisitante;
    public Equipo obtenerGanador() {
        return golesLocal > golesVisitante ? equipoLocal : golesLocal < golesVisitante ? equipoVisitante : null;
    }

}