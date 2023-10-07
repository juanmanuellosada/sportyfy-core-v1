package sportyfy.core.entidades.partido;

import lombok.*;
import sportyfy.core.entidades.equipo.Equipo;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PartidoJugado extends Partido {
    private Integer golesLocal;
    private Integer golesVisitante;

    public PartidoJugado(Equipo equipoLocal, Equipo equipoVisitante, Integer golesLocal, Integer golesVisitante) {
        super(equipoLocal, equipoVisitante);
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Equipo obtenerGanador() {
        return golesLocal > golesVisitante ? getEquipoLocal() : golesLocal < golesVisitante ? getEquipoVisitante() : null;
    }

    public Equipo obtenerPerdedor() {
        return golesLocal < golesVisitante ? getEquipoLocal() : golesLocal > golesVisitante ? getEquipoVisitante() : null;
    }

    public boolean esEmpate() {
        return Objects.equals(golesLocal, golesVisitante);
    }

    public boolean esLocal(Equipo equipo) {
        return getEquipoLocal().equals(equipo);
    }

    public boolean esVisitante(Equipo equipo) {
        return getEquipoVisitante().equals(equipo);
    }

    public boolean participa(Equipo equipo) {
        return esLocal(equipo) || esVisitante(equipo);
    }

    @Override
    public boolean tieneGoles() {
        return true;
    }
}