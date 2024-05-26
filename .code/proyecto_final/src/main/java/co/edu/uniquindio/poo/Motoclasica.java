package co.edu.uniquindio.poo;

//clase hija moto

public class Motoclasica extends Vehiculo {
    private double velocidadMaxima;

    public Motoclasica(String placa, String modelo, double velocidadMaxima) {
        super(placa, modelo);
        this.velocidadMaxima = velocidadMaxima;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
}
