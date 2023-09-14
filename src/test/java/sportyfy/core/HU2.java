package sportyfy.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HU2 {
    @Test
    public void MainTieneSaludoExtensible() {
        IniciadorSportyfyCore main = new IniciadorSportyfyCore();
        assert main.saludar().equals("¡Hola mundo!");
    }

    @Test
    public void segundoTestExtensible() {
        String msj = "prueba 2";
        assertEquals("prueba 2", msj);
    }
}