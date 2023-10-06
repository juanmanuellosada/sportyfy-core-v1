package sportyfy.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import sportyfy.core.entidades.Equipo;

@Data
@AllArgsConstructor
public class Pronostico {
    private Equipo equipoGanador;
}
