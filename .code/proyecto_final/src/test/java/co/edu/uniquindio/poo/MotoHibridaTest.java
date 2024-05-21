package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class MotoHibridaTest {
    
    private static final Logger LOG = Logger.getLogger(MotoHibridaTest.class.getName());
    @Test
    public void DatosCompletosMotoH(){
        LOG.info("prueba de datosCompletos de Moto Hibrida");
        Parqueadero parqueadero = new Parqueadero("ParqueosInc");
        assertEquals("ParqueosInc", parqueadero.getNombre());
    }

}