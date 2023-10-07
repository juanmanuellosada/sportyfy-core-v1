package sportyfy.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import sportyfy.core.entidades.equipo.Equipo;

@Data
@AllArgsConstructor
public class Pronostico {
    private Equipo equipoGanador;
}
