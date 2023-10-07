package sportyfy.core.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import sportyfy.core.entidades.equipo.Equipo;

import java.io.IOException;
import java.util.List;

@Data
public class EquiposParser {

    public List<Equipo> crearEquipos(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<Equipo>>() {});
    }
}
