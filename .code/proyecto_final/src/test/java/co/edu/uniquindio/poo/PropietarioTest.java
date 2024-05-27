package co.edu.uniquindio.poo;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PropietarioTest {

private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void DatosCompletosPropietario() {
        LOG.info("Prueba de datos completos de Propietario");
        Propietario propietario = new Propietario("Juan", "Pérez", "12345678");
        assertEquals("Juan", propietario.getNombre());
        assertEquals("Pérez", propietario.getApellido());
        assertEquals("12345678", propietario.getIdentificacion());
    }

    @Test
    public void DatosNulos() {
        LOG.info("Prueba datos nulos");
        assertThrows(Throwable.class, ()-> new Propietario(null,null,null));
        LOG.info("finalizando pruebas de datos nulos");
    }
}


