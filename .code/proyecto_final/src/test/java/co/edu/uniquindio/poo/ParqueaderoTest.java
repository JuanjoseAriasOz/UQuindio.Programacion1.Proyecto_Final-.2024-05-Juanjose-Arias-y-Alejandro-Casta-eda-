package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParqueaderoTest {

    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void datosCompletosParqueadero(){
        Parqueadero parqueadero = new Parqueadero("parqueos", 2, 2);
        StringBuilder gananciasMensaje = new StringBuilder();
        Carro carro = new Carro("AAA111", "Modelo A");
        Motoclasica motoClasica = new Motoclasica("BBB222", "Modelo B", 100);
        MotoHibrida motoHibrida = new MotoHibrida("CCC333", "Modelo C", 150);
        parqueadero.asignarPuesto(carro, 4, 5000);
        parqueadero.asignarPuesto(motoClasica, 5, 3000);
        parqueadero.mostrarGanancias(gananciasMensaje);
        parqueadero.cambiarDia();
        parqueadero.asignarPuesto(motoHibrida, 2, 9000);
        parqueadero.mostrarGanancias(gananciasMensaje);

        

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

