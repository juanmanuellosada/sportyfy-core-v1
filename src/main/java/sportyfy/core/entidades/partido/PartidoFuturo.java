package sportyfy.core.entidades.partido;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sportyfy.core.entidades.equipo.Equipo;

@EqualsAndHashCode(callSuper = true)
@Data
public class PartidoFuturo extends Partido {
    public PartidoFuturo(Equipo equipoLocal, Equipo equipoVisitante) {
        super(equipoLocal, equipoVisitante);
    }

    @Override
    public boolean tieneGoles() {
        return false;
    }
}
