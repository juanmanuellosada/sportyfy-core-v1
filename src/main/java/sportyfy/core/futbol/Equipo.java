package sportyfy.core.futbol;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class Equipo {
    private String nombre;
    private List<Partido> partidos;
}
