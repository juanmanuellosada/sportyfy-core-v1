package sportyfy.core.entidades.partido;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sportyfy.core.entidades.equipo.Equipo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    public abstract boolean tieneGoles();
}
