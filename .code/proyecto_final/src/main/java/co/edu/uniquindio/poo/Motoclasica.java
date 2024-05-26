package co.edu.uniquindio.poo;

//clase hija moto

 public class Motoclasica extends Vehiculo {
    private double velocidadMaxima;
    private static double tarifaPorHora = 1000;  // Ejemplo de tarifa por hora

    public Motoclasica(String placa, String modelo, String propietario, double velocidadMaxima) {
        super(placa, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public static void setTarifaPorHora(double tarifa) {
        tarifaPorHora = tarifa;
    }

    @Override
    public double getTarifaPorHora() {
        return tarifaPorHora;
    }
}
