package sportyfy.core;

import sportyfy.core.Pronostico;
import sportyfy.core.entidades.partido.PartidoFuturo;

public class PronosticoNull extends Pronostico {
    public PronosticoNull(PartidoFuturo partidoFuturo){
        super(null,partidoFuturo);
    }
}
