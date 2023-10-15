package sportyfy.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.ToString;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;

/**
 * Clase que representa un pronóstico
 */
@Data
@AllArgsConstructor
@ToString
public class Pronostico {
    private Equipo equipoGanador;
    private PartidoFuturo partidoFuturo;
}
