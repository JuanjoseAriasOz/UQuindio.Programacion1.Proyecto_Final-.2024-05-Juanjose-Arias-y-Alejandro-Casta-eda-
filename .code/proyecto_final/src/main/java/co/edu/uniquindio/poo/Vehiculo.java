package co.edu.uniquindio.poo;

/**
 * superclass Vehiculo asociada con Carro, Moto y MotoHibrida
 */
public abstract class Vehiculo {

    public static String placa;
    public static String modelo;

    public Vehiculo(String placa, String modelo){
        assert placa != null && !placa.isBlank();
        assert modelo != null && !modelo.isBlank();
    }

    /**
     * metodo abstracto para pribar el funcionamiento basico de la herencia
     */
    public abstract void encender();
}
