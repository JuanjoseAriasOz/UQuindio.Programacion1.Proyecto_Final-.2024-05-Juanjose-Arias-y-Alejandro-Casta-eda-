package co.edu.uniquindio.poo;
//variables o atributos de propietario.
public class Propietario {
    private String nombre;
    private String apellido;
    private String identificacion;
    
    public Propietario(String nombre, String apellido, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;

        assert nombre != null && !nombre.isBlank();
        assert apellido != null && !apellido.isBlank();
        assert identificacion != null && !identificacion.isBlank();
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

