package sportyfy.core.futbol;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
public class Equipo {
    private Integer id;
    private String nombre;
    private List<Partido> partidos;
}
