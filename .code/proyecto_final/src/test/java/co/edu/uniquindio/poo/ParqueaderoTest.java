package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;

public class ParqueaderoTest {
    private Parqueadero parqueadero;
    private Carro carro;
    private Motoclasica motoClasica;
    private MotoHibrida motoHibrida;

    public void setUp() {
        parqueadero = new Parqueadero("Mi Parqueadero", 5, 5);
        carro = new Carro("AAA111", "Modelo A", "Propietario A");
        motoClasica = new Motoclasica("BBB222", "Modelo B", "Propietario B", 100);
        motoHibrida = new MotoHibrida("CCC333", "Modelo C", "Propietario C", 150);
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

   

}

