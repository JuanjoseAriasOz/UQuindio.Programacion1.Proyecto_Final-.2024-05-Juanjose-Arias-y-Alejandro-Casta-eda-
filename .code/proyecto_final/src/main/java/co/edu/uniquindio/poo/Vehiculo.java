package co.edu.uniquindio.poo;

/**
 *Clase padre "Vehiculo" que heradara a sus hijos Carro, Moto y MotoHibrida
 */
public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private String propietario;
  //atributos de Vehiculo definidos  
    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }
//para ontener los atributos de vehiculo
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPropietario() {
        return propietario;
    }
//metodo abstracto para obtener la tarifa o lo del pago aún no sé como implementarlo bien, luego lo haré.
    public abstract double getTarifaPorHora();
}
