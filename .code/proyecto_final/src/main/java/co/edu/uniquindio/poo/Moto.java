package co.edu.uniquindio.poo;

/**
 * clace Moto que hereda de vehiculo los atributos placa y modelo
 */

public class Moto extends Vehiculo {

    private double velocidadMax;

    /**
     * constructor de la clase Moto
     * @param nombre, placa, modelo y velocidadMax
     */
    public Moto( double velocidadMax, String placa, String modelo){
        super(placa, modelo);
        assert placa != null && !placa.isBlank();
        assert modelo != null && !modelo.isBlank();
        assert velocidadMax < 0;
    }

    /**
     * metodos get para nombre, velocidadMax, placa y modelo 
    */
    public double getVelocidadMaxima(){
        return velocidadMax;
    }
    public String getPlaca(){
        return placa;
    }
    public String getModelo(){
        return modelo;
    }


    @Override
    public void encender(){
        System.out.println("la moto se esta encendiendo");
    }

    
}
