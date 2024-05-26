package co.edu.uniquindio.poo;

public class Puesto {
    private String[] posicion;
    private boolean ocupado;

    // Constructor
    public Puesto(String[] posicion, boolean ocupado) {
        this.posicion = posicion;
        this.ocupado = ocupado;
    }

    // Método para ocupar el puesto
    public void ocuparPuesto() {
        this.ocupado = true;
    }

    // Método para desocupar el puesto
    public void desocuparPuesto() {
        this.ocupado = false;
    }

    // Getters y Setters
    public String[] getPosicion() {
        return posicion;
    }

    public void setPosicion(String[] posicion) {
        this.posicion = posicion;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}

