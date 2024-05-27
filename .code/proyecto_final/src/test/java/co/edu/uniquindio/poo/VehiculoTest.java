package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class VehiculoTest {

    private static final Logger LOG = Logger.getLogger(Vehiculo.class.getName());
    @Test
    public void testDatosFuncionales() {
        LOG.info("Iniciando prueba de datos funcionales");
        Puesto puesto1 = new Puesto("1-1", false);
        assertEquals("1-1", puesto1.getPosicion());
        assertFalse(puesto1.getOcupado());
        assertThrows(Throwable.class, () -> new Puesto(null, false));
        assertThrows(Throwable.class, () -> new Puesto("", false));
        LOG.info("Finalizando prueba de datos funcionales");
    }

    @Test
    public void testOcuparPuesto() {
        Puesto puesto = new Puesto("2-1", false);
        puesto.ocuparPuesto();
        assertTrue(puesto.getOcupado());
        puesto.ocuparPuesto();
        assertTrue(puesto.getOcupado());
    }

    @Test
    public void testDesocuparPuesto() {
        LOG.info("Iniciado prueba");
        Puesto puesto = new Puesto("3-1", true);
        puesto.desocuparPuesto();
        assertFalse(puesto.getOcupado());
        puesto.desocuparPuesto();
        assertFalse(puesto.getOcupado());
        LOG.info("Finalizando prueba");
    
    }

    @Test
    public void testSetOcupado() {
        LOG.info("Iniciado prueba");
        Puesto puesto = new Puesto("4-1", false);
        puesto.setOcupado(true);
        assertTrue(puesto.getOcupado());
        puesto.setOcupado(false);
        assertFalse(puesto.getOcupado());
        LOG.info("Finalizando prueba");
    }
}

