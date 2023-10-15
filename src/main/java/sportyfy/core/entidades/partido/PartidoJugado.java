package sportyfy.core.entidades.partido;

import lombok.*;
import sportyfy.core.entidades.equipo.Equipo;

/**
 * Clase que representa un partido jugado en el sistema. Esta se usa para almacenar los resultados de los partidos.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PartidoJugado extends Partido {
    private Integer golesLocal;
    private Integer golesVisitante;

    public boolean esLocal(Equipo equipo) {
        return getEquipoLocal().equals(equipo);
    }

    public boolean esVisitante(Equipo equipo) {
        return getEquipoVisitante().equals(equipo);
    }

    public boolean participa(Equipo equipo) {
        return esLocal(equipo) || esVisitante(equipo);
    }

    public Equipo obtenerGanador() {
        if (golesLocal > golesVisitante) {
            return getEquipoLocal();
        } else if (golesLocal < golesVisitante) {
            return getEquipoVisitante();
        } else {
            return null;
        }
    }
}
