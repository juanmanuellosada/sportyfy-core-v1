package sportyfy.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PronosticoNull extends Pronostico {
    public PronosticoNull(){
        super(null);
    }
    @Override
    public boolean esEmpate(){
        return true;
    }
}
