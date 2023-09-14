package sportyfy.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HU1 {
    @Test
    public void MainTieneSaludo() {
        IniciadorSportyfyCore main = new IniciadorSportyfyCore();
        assert main.saludar().equals("¡Hola mundo!");
    }

    @Test
    public void SegundoTestPrueba() {
        assertEquals(2, 2);
    }
}
