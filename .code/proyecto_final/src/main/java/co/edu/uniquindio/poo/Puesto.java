package co.edu.uniquindio.poo;

public class Puesto {
    private String posicion;
    private boolean ocupado;

    // Constructor
    public Puesto(String posicion, boolean ocupado) {
        this.posicion = posicion;
        this.ocupado = ocupado;
    }

    // Getters
    public String getPosicion() {
        return posicion;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    // Método para ocupar el puesto
    public void ocuparPuesto() {
        if (!ocupado) {
            ocupado = true;
            System.out.println(posicion);
        } else {
            System.out.println(posicion);
        }
    }

    // Método para desocupar el puesto
    public void desocuparPuesto() {
        if (ocupado) {
            ocupado = false;
            System.out.println(posicion );
        } else {
            System.out.println(posicion);
        }
    }

    // Setter para marcar el puesto como ocupado o desocupado
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }


}


