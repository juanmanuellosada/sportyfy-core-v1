package sportyfy.core.entidades.partido;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sportyfy.core.entidades.equipo.Equipo;

/**
 * Clase que representa un partido futuro en el sistema. Esta se usa para pasarse como parámetro a la función
 * pronosticar.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PartidoFuturo extends Partido {
    public PartidoFuturo(Equipo equipoLocal, Equipo equipoVisitante) {
        super(equipoLocal, equipoVisitante);
    }
}
