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

    public List<Equipo> crearEquipos(String ruta) {
        ObjectMapper mapper = new ObjectMapper();
        List<Equipo> equipos = null;

        try {
            equipos = mapper.readValue(new File(ruta), new TypeReference<List<Equipo>>(){});
        } catch (IOException e) {
            Logger.getLogger("ConstructorEquipos").severe("No se pudo cargar el archivo de equipos");
        }

        return equipos;
    }
}
