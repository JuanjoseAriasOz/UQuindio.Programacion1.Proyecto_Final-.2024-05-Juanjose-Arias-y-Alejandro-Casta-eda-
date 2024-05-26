package co.edu.uniquindio.poo;
//clase hija carro
public class Carro extends Vehiculo {
    private static double tarifaPorHora = 2000;  

    public Carro(String placa, String modelo, String propietario) {
        super(placa, modelo, propietario);
    }
    public static void setTarifaPorHora(double tarifa) {
        tarifaPorHora = tarifa;
    }

    @Override
    public double getTarifaPorHora() {
        return tarifaPorHora;
    }
}
