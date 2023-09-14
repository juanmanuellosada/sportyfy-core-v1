package sportyfy.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import sportyfy.core.futbol.Equipo;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Data
public class ConstructorEquipos {

    public List<Equipo> crearEquipos(String ruta) {
        ObjectMapper mapper = new ObjectMapper();
        List<Equipo> equipos = null;

        try {
            equipos = mapper.readValue(new File(ruta), new TypeReference<List<Equipo>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(equipos);

        return equipos;
    }
}
