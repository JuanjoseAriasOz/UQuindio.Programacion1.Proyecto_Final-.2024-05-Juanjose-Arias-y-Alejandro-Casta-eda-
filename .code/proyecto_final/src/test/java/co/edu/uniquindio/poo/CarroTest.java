package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class CarroTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void ProbarCarro(){
        LOG.info("iniciando prueba de datos completos");
        Carro carro = new Carro("HDP 123", "renos");
        assertEquals("HDP 123", carro.getPlaca());
        assertEquals("renos", carro.getModelo());
    }
}