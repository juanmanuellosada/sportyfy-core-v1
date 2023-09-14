package sportyfy.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.EqualsAndHashCode;
import sportyfy.core.futbol.Equipo;

import java.util.Observable;

@Data
@AllArgsConstructor
public class Pronostico {
    private Equipo equipoGanador;
}
