package sportyfy.core;

import lombok.Data;

import sportyfy.core.futbol.Equipo;

import java.util.Observable;

@Data
public class Pronostico extends Observable {
    private Equipo equipoGanador;

    public Pronostico (Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
        this.notifyAll();
    }
}
