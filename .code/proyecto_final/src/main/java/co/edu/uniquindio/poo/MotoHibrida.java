package co.edu.uniquindio.poo;

public class MotoHibrida extends Vehiculo{
    
    public double velocidadMax;
    public MotoHibrida(double velocidadMax, String placa, String modelo){
        super(placa, modelo);
        assert placa != null && !placa.isBlank();
        assert modelo != null && !modelo.isBlank();
        assert velocidadMax < 0;
    }
    @Override
    public void encender(){
        System.out.println("moto hibrida encendida");
    }
    
}
