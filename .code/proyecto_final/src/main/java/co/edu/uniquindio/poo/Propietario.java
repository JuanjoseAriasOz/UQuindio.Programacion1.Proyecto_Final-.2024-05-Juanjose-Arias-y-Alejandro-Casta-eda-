package co.edu.uniquindio.poo;

public class Propietario {
    private String nombre;
    private String apellido;
    private String identificacion;
    
    public Propietario(String nombre, String apellido, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

}

