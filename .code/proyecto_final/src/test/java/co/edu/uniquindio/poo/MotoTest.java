package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


public class MotoTest {

    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());
    @Test
    public void DatosCompletosMoto(){
        LOG.info("prueba de datosCompletos de Moto");
        Motoclasica motoclasica = new Motoclasica("HDP 123", "renol", 18);
        assertEquals("HDP 123", motoclasica.getPlaca());
        assertEquals("renol", motoclasica.getModelo());
    }
        
    @Test
    public void Datosnulos(){
        LOG.info("Prueba datos nulos");
        assertThrows(Throwable.class, ()-> new Motoclasica(null, null, 0));
    }
    
    @Test
    public void Datosvacios(){
        LOG.info("prueba datos vacios");
        assertThrows(Throwable.class,()-> new MotoHibrida("", "", 0));
    }

}