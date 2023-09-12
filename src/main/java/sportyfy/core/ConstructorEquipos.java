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
    private List<Equipo> equipos;

    // TODO: Implementar método crearEquipos que lea los JSONS y cree los equipos
    // con sus partidos
    public void crearEquipos() {
        ObjectMapper mapper = new ObjectMapper();
        String ruta = "datosFutbol/equipos/equipos.json";

        try {
            // Lee el archivo JSON y mapea su contenido a una lista de objetos Equipo
            File jsonFile = new File(ruta);
            equipos = mapper.readValue(jsonFile, new TypeReference<List<Equipo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
