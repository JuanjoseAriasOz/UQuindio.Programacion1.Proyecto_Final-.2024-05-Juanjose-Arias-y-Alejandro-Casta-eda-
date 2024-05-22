package co.edu.uniquindio.poo;

public class Ingreso {
    private Parqueadero parqueadero;

    public Ingreso(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public void registrarIngreso(String vehiculo) {
        int[] puesto = parqueadero.asignarPuesto(vehiculo);
        if (puesto != null) {
            System.out.println("Vehículo " + vehiculo + " asignado al puesto: [" + puesto[0] + ", " + puesto[1] + "]");
        } else {
            System.out.println("No hay puestos disponibles para el vehículo " + vehiculo);
        }
    }

    public boolean verificarPuesto(int fila, int columna) {
        return parqueadero.estaOcupado(fila, columna);
    }

    public void asignarPuesto(String vehiculo, int fila, int columna) {
        if (parqueadero.agregarVehiculo(fila, columna, vehiculo)) {
            System.out.println("Vehículo " + vehiculo + " asignado al puesto: [" + fila + ", " + columna + "]");
        } else {
            System.out.println("El puesto [" + fila + ", " + columna + "] está ocupado.");
        }
    }

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Ingreso ingreso = new Ingreso(parqueadero);
        ingreso.registrarIngreso("Carro1");
        ingreso.mostrarEstado();
    }
}

