package sportyfy.core.entidades.equipo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Clase que representa un equipo en el sistema.
 */
@Data
@EqualsAndHashCode
@ToString
public class Equipo {
    private Integer id;
    private String nombre;
}
