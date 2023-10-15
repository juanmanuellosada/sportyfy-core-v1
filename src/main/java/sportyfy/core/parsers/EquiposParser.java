package sportyfy.core.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import sportyfy.core.entidades.equipo.Equipo;

import java.io.IOException;
import java.util.List;

/**
 * Clase que realiza el análisis de JSON para crear una lista de equipos.
 */
public class EquiposParser {

    /**
     * Crea una lista de equipos a partir de un JSON.
     * @param json JSON que contiene la lista de equipos.
     * @return Lista de equipos creada a partir del JSON.
     * @throws IOException Si ocurre un error al analizar el JSON.
     */
    public List<Equipo> crearEquipos(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<Equipo>>() {});
    }
}
