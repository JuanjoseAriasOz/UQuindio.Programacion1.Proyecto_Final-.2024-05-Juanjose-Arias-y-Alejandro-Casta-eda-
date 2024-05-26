package co.edu.uniquindio.poo;

//clase hija moto hibrida
public class MotoHibrida extends Vehiculo {
    private double velocidadMaxima;

    public MotoHibrida(String placa, String modelo, String propietario, double velocidadMaxima) {
        super(placa, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
}
