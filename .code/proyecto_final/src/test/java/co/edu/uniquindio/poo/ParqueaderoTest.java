package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;


public class ParqueaderoTest {

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
        LOG.info("iniciando prueba asignar carro");
        double tarifaPorHora = 8500;
        int tiempoEstadia = 2;
        Parqueadero parqueadero = new Parqueadero("parqueosindustry", 2, 2);
        Carro carro = new Carro("AAA 111", "A");

        parqueadero.asignarPuesto(carro, tiempoEstadia, tarifaPorHora);
        Puesto puesto = parqueadero.obtenerPuestoDisponible();

        assertEquals("AAA 111", carro.getPlaca());
        assertEquals(parqueadero.obtenerVehiculos().get(0).getHoraEntrada().toLocalDate(), LocalDateTime.now().toLocalDate());
        assertTrue(!puesto.getOcupado());
    }

    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());
    private Parqueadero parqueadero;

    @BeforeEach
    public void testAsignarPuesto() {
        LOG.info("iniciando prueba de asigar puesto");
        parqueadero = new Parqueadero("Mi Parqueadero", 5, 5);
        LOG.info("finalizando prueba de asigar puesto");

    }

    @Test
    public void testAgregarPuesto() {
        LOG.info("iniciando prueba de agregar puesto");
        Puesto puesto = new Puesto("Puesto 1-1", false);
        parqueadero.agregarPuesto(puesto, 0, 0);
        assertEquals(puesto, parqueadero.getPuesto()[0][0]);
        LOG.info("finalizando prueba de agregar puesto");

    }
    @Test
    public void Filasnulas(){
        LOG.info("Iniciando prueba de filas nulas");
        assertThrows(Throwable.class, ()-> new Parqueadero("Mi Parqueadero", 0, 5));
        LOG.info("Finalizando prueba de tfilas nulas");
    }
    @Test
    public void Columnasnulas(){
        LOG.info("Iniciando prueba de las columnas nulas");
        assertThrows(Throwable.class, ()-> new Parqueadero("Mi Parqueadero", 5, 0));
        LOG.info("Finalizando prueba de columnas nulas");
    }
}

