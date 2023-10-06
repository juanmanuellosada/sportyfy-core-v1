package sportyfy.core.core;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.Pronostico;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.entidades.PartidoAnterior;
import sportyfy.core.entidades.PartidoFuturo;

import java.util.List;
import java.util.Observable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class SportyfyCore extends Observable {

    private Set<Pronosticador> pronosticadores;
    private Pronostico pronosticoActual;
    private List<Equipo> equipos;
    private List<PartidoAnterior> partidosAnteriores;

    /* Puedo contruir el modelo sin tener pronóstico actual */
    public SportyfyCore(Set<Pronosticador> pronosticadores, List<Equipo> equipos, List<PartidoAnterior> partidosAnteriores) {
        this.pronosticadores = pronosticadores;
        this.equipos = equipos;
        this.partidosAnteriores = partidosAnteriores;
    }

    public void pronosticar(PartidoFuturo partidoFuturo, List<PartidoAnterior> partidosAnteriores, String nombrePronosticador) {
        BuscadorPronosticadores buscadorPronosticadores = new BuscadorPronosticadores();
        Pronosticador pronosticador = buscadorPronosticadores.buscarPronosticador(pronosticadores, nombrePronosticador);
        if (pronosticador != null) {
            pronosticoActual = pronosticador.pronosticar(partidoFuturo.getEquipoLocal(), partidoFuturo.getEquipoVisitante(), partidosAnteriores);
            setChanged();
            notifyObservers();
        } else {
            throw new IllegalArgumentException("No se encontró el pronosticador con nombre " + nombrePronosticador);
        }
    }




}
