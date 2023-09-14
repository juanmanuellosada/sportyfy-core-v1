package sportyfy.core;

import lombok.Data;

import lombok.EqualsAndHashCode;
import sportyfy.core.futbol.Equipo;

import java.util.Observable;

@Data
@EqualsAndHashCode(callSuper=false)
public class Pronostico extends Observable {
    private Equipo equipoGanador;

    public Pronostico (Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }
}
