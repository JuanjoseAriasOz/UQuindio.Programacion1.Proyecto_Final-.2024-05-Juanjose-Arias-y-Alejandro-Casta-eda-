package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class ParqueaderoTest {
        private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());
        @Test
        public void DatosCompletosPaqueadero(){
            Parqueadero parqueadero = new Parqueadero("ParqueosInc");
            assertEquals("ParqueosInc", parqueadero.getNombre());
        }

}
