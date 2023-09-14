package sportyfy.core;

import org.junit.Test;

public class IniciadorSportyfyCoreTest {
    @Test
    public void MainTieneSaludo() {
        IniciadorSportyfyCore iniciadorSportyfyCore = new IniciadorSportyfyCore();
        assert iniciadorSportyfyCore.saludar().equals("¡Hola mundo!");
    }
}
