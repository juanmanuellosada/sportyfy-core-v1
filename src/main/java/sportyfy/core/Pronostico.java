package sportyfy.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.ToString;
import sportyfy.core.entidades.equipo.Equipo;

@Data
@AllArgsConstructor
@ToString
public class Pronostico {
    private Equipo equipoGanador;
}
