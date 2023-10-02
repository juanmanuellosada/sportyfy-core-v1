package sportyfy.core.modelo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.Pronostico;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.Partido;

import java.util.List;
import java.util.Observable;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
public class SportyfyCore extends Observable {

    private BuscadorPronosticadores buscadorPronosticadores;
    private Pronostico pronosticoActual;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    /* Puedo contruir el modelo sin tener pronóstico actual */
    public SportyfyCore(BuscadorPronosticadores buscadorPronosticadores, List<Equipo> equipos, List<Partido> partidos) {
        this.buscadorPronosticadores = buscadorPronosticadores;
        this.equipos = equipos;
        this.partidos = partidos;
    }

    public void pronosticar(Equipo equipoLocal, Equipo equipoVisitante, List<Partido> partidosAnteriores, String nombrePronosticador) {
        Optional<Pronosticador> pronosticador = buscadorPronosticadores.buscarPronosticador(nombrePronosticador);
        if (pronosticador.isPresent()) {
            pronosticoActual = pronosticador.get().pronosticar(equipoLocal, equipoVisitante, partidosAnteriores);
            setChanged();
            notifyObservers();
        } else {
            throw new RuntimeException("No se ha encontrado el pronosticador " + nombrePronosticador);
        }
    }

}
