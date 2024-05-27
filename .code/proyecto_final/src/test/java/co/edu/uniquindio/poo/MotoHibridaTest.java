package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


public class MotoHibridaTest {
    
    private static final Logger LOG = Logger.getLogger(MotoHibridaTest.class.getName());

    @Test
    public void DatosCompletosMotoH(){
        LOG.info("Prueba de datos completos de Moto Hibrida");
        MotoHibrida motoHibrida = new MotoHibrida("HDP 123", "jawar", 150);
        assertEquals("HDP 123", motoHibrida.getPlaca());
        assertEquals("jawar", motoHibrida.getModelo());
        assertEquals(150, motoHibrida.getVelocidadMaxima());
    }
}
