package sportyfy.core.core;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.Pronostico;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.entidades.partido.PartidoJugado;

import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("deprecation")
public class SportyfyCore extends Observable {

    private Set<Pronosticador> pronosticadores;
    private Pronostico pronosticoActual;
    private List<Equipo> equipos;
    private List<PartidoJugado> partidosJugados;

    /* Puedo contruir el modelo sin tener pronóstico actual */
    public SportyfyCore(Set<Pronosticador> pronosticadores, List<Equipo> equipos, List<PartidoJugado> partidosJugados) {
        this.pronosticadores = pronosticadores;
        this.equipos = equipos;
        this.partidosJugados = partidosJugados;
    }

    public void pronosticar(PartidoFuturo partidoFuturo, String nombrePronosticador) {
        BuscadorPronosticadores buscadorPronosticadores = new BuscadorPronosticadores();
        Pronosticador pronosticador = buscadorPronosticadores.buscarPronosticador(pronosticadores, nombrePronosticador);
        if (pronosticador != null) {
            pronosticoActual = pronosticador.pronosticar(partidoFuturo, this.partidosJugados);
            setChanged();
            notifyObservers();
        }
        else{
            throw new IllegalArgumentException("No se encontró el pronosticador con nombre " + nombrePronosticador);
        }
    }

    public List<String> obtenerNombresPronosticadores(Set<Pronosticador> pronosticadores) {
        return pronosticadores.stream()
                .map(pronosticador -> pronosticador.getClass().getSimpleName())
                .collect(Collectors.toList());
    }




}
