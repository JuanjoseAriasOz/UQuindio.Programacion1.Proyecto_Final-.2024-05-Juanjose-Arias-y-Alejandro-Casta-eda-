package co.edu.uniquindio.poo;

import java.util.LinkedList;
import java.util.Collection;


/**
 * clase principal Parqueadero, que contendra los puestos que a su vez contendran los vehiculos
 */
public class Parqueadero {

    public Collection <Puesto> puestos;
    public Collection <Propietario> propietarios;
    private String nombre;

    Parqueadero(String nombre){
        puestos = new LinkedList<>();
        propietarios = new LinkedList<>();
        assert nombre != null;
    }

    public String getNombre(){
        return nombre;
    }
    
}
