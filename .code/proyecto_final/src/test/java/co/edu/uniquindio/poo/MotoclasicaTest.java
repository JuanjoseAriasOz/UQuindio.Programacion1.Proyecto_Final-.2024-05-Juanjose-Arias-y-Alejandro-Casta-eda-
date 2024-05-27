package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


public class MotoclasicaTest {

    private static final Logger LOG = Logger.getLogger(MotoclasicaTest.class.getName());
    
    @Test
    public void DatosCompletosMoto(){
        LOG.info("prueba de datosCompletos de Moto");
        Motoclasica motoclasica = new Motoclasica("HDP 123", "renol", 150);
        assertEquals("HDP 123", motoclasica.getPlaca());
        assertEquals("renol", motoclasica.getModelo());
        assertEquals(150, motoclasica.getVelocidadMaxima());
        LOG.info("finalizando la prueba de datos completos");
    }

    @Test
    public void Datosnulos(){
        LOG.info("Prueba datos nulos");
        assertThrows(Throwable.class, ()-> new Motoclasica(null, null, 0));
        LOG.info("Finalizando Prueba de datos completamente ");
    }
    
    @Test
    public void Datosvacios(){
        LOG.info("prueba datos vacios");
        assertThrows(Throwable.class, ()-> new Motoclasica("","",0));
    }

}
