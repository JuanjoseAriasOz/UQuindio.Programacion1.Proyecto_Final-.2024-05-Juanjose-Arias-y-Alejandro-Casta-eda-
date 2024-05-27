package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class CarroTest {

    private static final Logger LOG = Logger.getLogger(CarroTest.class.getName());

    @Test
    public void Datoscompletos() {
        LOG.info("Iniciando prueba de datos completos");
        Carro carro = new Carro("HDP 123", "Renault");
        assertEquals("HDP 123", carro.getPlaca());
        assertEquals("Renault", carro.getModelo());
        LOG.info("Finalizando prueba de datos completos");
    }

    @Test
    public void Datosnulos(){
        LOG.info("Prueba datos nulos");
        assertThrows(Throwable.class, ()-> new Carro(null, null));
        LOG.info("Prueba datos nulos finalizada");
    }

    @Test
    public void Datosvacios(){
        LOG.info("prueba datos vacios");
        assertThrows(Throwable.class,()-> new Carro("", ""));
        LOG.info("Prueba datos vacios finalizada");
    }
}