package co.edu.uniquindio.poo;

//clase hija moto

public class Motoclasica extends Vehiculo {
    private double velocidadMaxima;

    public Motoclasica(String placa, String modelo, double velocidadMaxima) {
        super(placa, modelo);
        this.velocidadMaxima = velocidadMaxima;
        assert placa != null && !placa.isBlank();
        assert modelo != null && !modelo.isBlank();    
        assert velocidadMaxima < 0;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
}
