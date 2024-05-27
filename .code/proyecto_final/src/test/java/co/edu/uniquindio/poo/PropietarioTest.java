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
    public void NombreNuloPropietario() {
        LOG.info("Prueba de nombre nulo de Propietario");
        assertThrows(AssertionError.class, () -> {
            new Propietario(null, "Pérez", "12345678");
        });
    }

    @Test
    public void ApellidoNuloPropietario() {
        LOG.info("Prueba de apellido nulo de Propietario");
        assertThrows(AssertionError.class, () -> {
            new Propietario("Juan", null, "12345678");
        });
    }

    @Test
    public void IdentificacionNulaPropietario() {
        LOG.info("Prueba de identificación nula de Propietario");
        assertThrows(AssertionError.class, () -> {
            new Propietario("Juan", "Pérez", null);
        });
    }
}


