package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public class Ingreso {
    private Vehiculo vehiculo;
    private Puesto puesto;
    //LocalDatetime esto es para decir a que hora entro el vehiculo, pero aun no sé como se usa bien lo dejare ahi por el momento
    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;

    // Constructor
    public Ingreso(Vehiculo vehiculo, Puesto puesto) {
        this.vehiculo = vehiculo;
        this.puesto = puesto;
        this.horaIngreso = LocalDateTime.now();  // Registra la hora actual como hora de ingreso
    }

    // Getters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }
//aún no sé como usar lo de abajo lo deje ahi por el momento estoy viendo videos de youtube para entender pero eso esta muy raro, estoy que descarto esta idea

    // Método para registrar la hora de salida
    public void registrarSalida() {
        this.horaSalida = LocalDateTime.now();  // Registra la hora actual como hora de salida
    }

    // Método para calcular el costo del parqueo
    public void calcularCosto() {
        if (horaSalida == null) {
            registrarSalida();  // Si no se ha registrado la salida, se registra ahora
        }
    }

    // Método estático para registrar el ingreso
    public static void registrarIngreso(Vehiculo vehiculo, Puesto puesto) {
        puesto.setOcupado(true);  // Marcar el puesto como ocupado
        System.out.println("Ingreso registrado para el vehículo con placa " + vehiculo.getPlaca() + " en el puesto " + puesto.getNombre());
    }
}
