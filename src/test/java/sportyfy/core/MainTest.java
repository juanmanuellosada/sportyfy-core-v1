package sportyfy.core;

import org.junit.Test;

public class MainTest {
    @Test
    public void MainTieneSaludo() {
        Main main = new Main();
        assert main.saludar().equals("¡Hola mundo!");
    }
}
