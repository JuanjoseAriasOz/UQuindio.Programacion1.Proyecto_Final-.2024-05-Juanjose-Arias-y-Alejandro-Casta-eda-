package co.edu.uniquindio.poo;


import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class IngresoTest {

        private static final Logger LOG = Logger.getLogger(IngresoTest.class.getName());

    @Test
    public void testdatosCompletos() {
        LOG.info("iniciando prueba de datos cpmpletos de ingreso");
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota");
        Puesto puesto = new Puesto("1-1", false);
        Ingreso ingreso = new Ingreso(vehiculo, puesto);

        assertEquals(vehiculo, ingreso.getVehiculo());
        assertEquals(puesto, ingreso.getPuesto());
        assertNotNull(ingreso.getHoraIngreso());
        assertNull(ingreso.getHoraSalida());
    }

    @Test
    public void testRegistrarSalida() {
        LOG.info("iniciando prueba de registrar salida de ingreso");
        Vehiculo vehiculo = new Vehiculo("XYZ789", "Honda");
        Puesto puesto = new Puesto("1-2", false);
        Ingreso ingreso = new Ingreso(vehiculo, puesto);
        LocalDateTime horaIngreso = LocalDateTime.now();
        ingreso.registrarSalida();
        LocalDateTime horaSalida = ingreso.getHoraSalida();
        assertNotNull(horaSalida);
        assertFalse(horaSalida.isAfter(horaIngreso));
    }

    @Test
    public void testRegistrarIngreso() {
        LOG.info("iniciando prueba de registrar salida de ingreso");
        Vehiculo vehiculo = new Vehiculo("DEF456", "Ford");
        Puesto puesto = new Puesto("1-3", false);
        assertFalse(puesto.getOcupado()); 
        Ingreso.registrarIngreso(vehiculo, puesto);
        assertTrue(puesto.getOcupado()); 
    }
}

