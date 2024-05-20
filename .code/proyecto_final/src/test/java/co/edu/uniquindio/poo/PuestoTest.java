package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    //Test para probar el funcionamiento del metodo Puesto
    @Test
    public void DatosCompletosPuesto(){
        LOG.info("Prueba de datos del puesto");
        Parqueadero parqueadero = new Parqueadero("ParqueosInc");
        Carro carro = new Carro("JHN-117", "Mark 7"); 
        puesto.Ocupar_puesto(carro);
        assertEquals(1, parqueadero.getNPuestos());
    }
    
}
