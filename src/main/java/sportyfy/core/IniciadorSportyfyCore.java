package sportyfy.core;

import lombok.Data;

@Data
public class IniciadorSportyfyCore {

    private ConstructorEquipos constructorEquipos;
    private BuscadorPronosticadores buscadorPronosticadores;

    public void iniciar(String ruta) {
        this.constructorEquipos = new ConstructorEquipos();
        this.constructorEquipos.crearEquipos();

        this.buscadorPronosticadores = new BuscadorPronosticadores();
        this.buscadorPronosticadores.encontrarPronosticadores(ruta);
    }

    //Dejo este método porque lo usa el test de ejemplo, pero no iría
    public String saludar() {
        return "¡Hola mundo!";
    }
}