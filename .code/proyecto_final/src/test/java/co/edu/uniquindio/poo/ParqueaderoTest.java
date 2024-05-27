package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


public class ParqueaderoTest {

    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());
        private Parqueadero parqueadero;
    
        @BeforeEach
        public void testAsignarPuesto() {
            parqueadero = new Parqueadero("Mi Parqueadero", 5, 5);
        }
    
        @Test
        public void testAgregarPuesto() {
            // Crear un nuevo puesto
            Puesto puesto = new Puesto("Puesto 1-1", false);
    
            // Agregar el puesto al parqueadero en la posición (0, 0)
            parqueadero.agregarPuesto(puesto, 0, 0);
    
            // Verificar si el puesto se agregó correctamente al parqueadero
            assertEquals(puesto, parqueadero.getPuesto()[0][0]);

    }
    
    @Test
    public void datosCompletosParqueadero(){
        LOG.info("prueba datos correctos en parqueadero");
        Parqueadero parqueadero = new Parqueadero("parqueos", 2, 2);
        StringBuilder gananciasMensaje = new StringBuilder();
        Carro carro = new Carro("AAA 111", "A");
        Motoclasica motoClasica = new Motoclasica("BBB 222", "B", 100);
        MotoHibrida motoHibrida = new MotoHibrida("CCC 333", "C", 150);
        parqueadero.asignarPuesto(carro, 4, 5000);
        parqueadero.asignarPuesto(motoClasica, 5, 3000);
        parqueadero.mostrarGanancias(gananciasMensaje);
        parqueadero.cambiarDia();
        parqueadero.asignarPuesto(motoHibrida, 2, 9000);
        parqueadero.mostrarGanancias(gananciasMensaje);
    }
    @Test
    public void AsignarPuestoCarroTest(){
        double tarifaPorHora = 8500;
        int tiempoEstadia = 2;
        Parqueadero parqueadero = new Parqueadero("parqueosindustry", 2, 2);
        Carro carro = new Carro("AAA 111", "A");

        parqueadero.asignarPuesto(carro, tiempoEstadia, tarifaPorHora);
        Puesto puesto = parqueadero.obtenerPuestoDisponible();

        Assertions.assertEquals("AAA 111", carro.getPlaca());
        Assertions.assertEquals(parqueadero.obtenerVehiculos().get(0).getHoraEntrada().toLocalDate(), LocalDateTime.now().toLocalDate());
        assertTrue(!puesto.getOcupado());
    }
/**
    public void setUp() {
    }

    public void testAsignarPuestoCarro() {
        double tarifaPorHora = 8500;
        int tiempoEstadia = 2; // 2 horas

        parqueadero.asignarPuesto(carro, tiempoEstadia, tarifaPorHora);
        Puesto puesto = parqueadero.obtenerPuestoDisponible();

        Assertions.assertEquals(carro.getPlaca(), parqueadero.obtenerVehiculos().get(0).getPlaca());
        Assertions.assertEquals(parqueadero.obtenerVehiculos().get(0).getHoraEntrada().toLocalDate(), LocalDateTime.now().toLocalDate());
        assertNotNull(puesto);
        assertTrue(puesto.getOcupado());
    }

    public void testGananciasDiariasCarro() {
        double tarifaPorHora = 8500;
        int tiempoEstadia = 2; // 2 horas

        parqueadero.asignarPuesto(carro, tiempoEstadia, tarifaPorHora);

        assertEquals(17000, parqueadero.obtenerGananciasDiarias(), 0);
        assertEquals(17000, parqueadero.obtenerGananciasDiarias(), 0);
    }

   
    private void assertEquals(int i, Object obtenerGananciasDiarias, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    public void testAsignarPuestoMotoClasica() {
        double tarifaPorHora = 6000;
        int tiempoEstadia = 2; // 2 horas

        parqueadero.asignarPuesto(motoClasica, tiempoEstadia, tarifaPorHora);
        Puesto puesto = parqueadero.obtenerPuestoDisponible();

        Assertions.assertEquals(motoClasica.getPlaca(), parqueadero.obtenerVehiculos().get(0).getPlaca());
        assertNotNull(puesto);
        assertTrue(puesto.getOcupado());
    }

   
    public void testGananciasDiariasMotoClasica() {
        double tarifaPorHora = 6000;
        int tiempoEstadia = 2; // 2 horas

        parqueadero.asignarPuesto(motoClasica, tiempoEstadia, tarifaPorHora);

        assertEquals(12000, parqueadero.obtenerGananciasDiarias(), 0);
        assertEquals(12000, parqueadero.obtenerGananciasDiariasMotoclasica(), 0);
    }

    
    public void testCambioDia() {
        double tarifaPorHoraCarro = 8500;
        double tarifaPorHoraMotoClasica = 6000;
        int tiempoEstadia = 2; // 2 horas

        parqueadero.asignarPuesto(carro, tiempoEstadia, tarifaPorHoraCarro);
        parqueadero.asignarPuesto(motoClasica, tiempoEstadia, tarifaPorHoraMotoClasica);

        parqueadero.cambiarDia();

        assertEquals(0, parqueadero.obtenerGananciasDiarias(), 0);
        assertEquals(29000, parqueadero.obtenerGananciasDiarias(), 0);
    }

  */ 

}

