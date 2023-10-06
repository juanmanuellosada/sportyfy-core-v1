package sportyfy.core.constructores;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import sportyfy.core.entidades.Equipo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Data
public class ConstructorEquipos {

    public List<Equipo> crearEquipos(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<Equipo>>() {});
    }
}
