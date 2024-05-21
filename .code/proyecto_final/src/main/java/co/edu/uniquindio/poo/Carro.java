package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {


    public Carro(String placa, String modelo){
        super(placa, modelo);
        assert placa != null && !placa.isBlank();
        assert modelo != null && !modelo.isBlank();
    }
    
    @Override
    public void encender(){
        System.out.println("carro encendido");

    /**
     * metodos get para placa y modelo 
    */
    }
    public String getPlaca(){
        return placa;
    }
    public String getModelo(){
        return modelo;
    }
}
