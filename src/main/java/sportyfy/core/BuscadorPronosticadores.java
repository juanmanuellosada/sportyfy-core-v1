package sportyfy.core;

import lombok.Data;

import java.util.Set;

@Data
public class BuscadorPronosticadores {
    private Set<Pronosticador> pronosticadores;

    //TODO: Implementar método encontrarPronosticadores que reciba una ruta y devuelva un Set de Pronosticadores
    public Set<Pronosticador> buscarPronosticadores(String ruta) {
        return null;
    }
}
