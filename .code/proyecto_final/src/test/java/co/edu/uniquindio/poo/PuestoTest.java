package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    //Test para probar el funcionamiento del metodo Puesto
    @Test
    public void DatosCompletosPuesto(){
        LOG.info("Prueba de datos del puesto");
        Parqueadero parqueadero = new Parqueadero("ParqueosInc", 2, 2);
        Carro carro = new Carro("JHN-117", "Mark 7"); 
        parqueadero.asignarPuesto(carro, 3, 4000);
        assertEquals(1, parqueadero.obtenerVehiculos());
    }
    
}