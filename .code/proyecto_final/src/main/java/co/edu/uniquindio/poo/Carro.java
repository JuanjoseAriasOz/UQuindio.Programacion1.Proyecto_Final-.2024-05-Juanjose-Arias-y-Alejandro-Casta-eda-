package co.edu.uniquindio.poo;
//clase hija carro
public class Carro extends Vehiculo {

    public Carro(String placa, String modelo) {
        super(placa, modelo);
        assert placa != null && !placa.isBlank();
        assert modelo != null && !modelo.isBlank();
    }
}
