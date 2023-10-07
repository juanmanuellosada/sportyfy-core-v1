package sportyfy.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class SelectorPronosticadores {

    private Set<Pronosticador> pronosticadores;

    public Pronosticador seleccionarPronosticador(String nombreClase) {
        return pronosticadores.stream()
                .filter(pronosticador -> pronosticador.getClass().getSimpleName().equals(nombreClase))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró el pronosticador " + nombreClase));
    }


}
