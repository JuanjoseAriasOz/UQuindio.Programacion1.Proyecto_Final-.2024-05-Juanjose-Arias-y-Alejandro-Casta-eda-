package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Parqueadero {
    private String nombre;
    private List<Puesto> puestos;
    private List<Vehiculo> vehiculos;

    public Parqueadero(String nombre) {
        this.nombre = nombre;
        this.puestos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPuesto(Puesto puesto) {
        puestos.add(puesto);
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Puesto obtenerPuestoDisponible() {
        for (Puesto puesto : puestos) {
            if (!puesto.isOcupado()) {
                return puesto;
            }
        }
        return null;
    }

    public void asignarPuesto(Vehiculo vehiculo) {
        Puesto puestoDisponible = obtenerPuestoDisponible();
        if (puestoDisponible != null) {
            puestoDisponible.ocuparPuesto();
            registrarVehiculo(vehiculo);
            System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha sido asignado al puesto " + puestoDisponible.getPosicion());
        } else {
            System.out.println("No hay puestos disponibles.");
        }
    }

    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero("Mi Parqueadero");

        // Crear y agregar puestos
        parqueadero.agregarPuesto(new Puesto("A1", false));
        parqueadero.agregarPuesto(new Puesto("A2", false));
        parqueadero.agregarPuesto(new Puesto("B1", false));
        parqueadero.agregarPuesto(new Puesto("B2", false));

        // Preguntar cuántos vehículos se desean ingresar
        String numeroVehiculosStr = JOptionPane.showInputDialog("Ingrese el número de vehículos que desea ingresar:");
        int numeroVehiculos = Integer.parseInt(numeroVehiculosStr);

        StringBuilder mensaje = new StringBuilder();

        for (int i = 0; i < numeroVehiculos; i++) {
            // Pedir datos del propietario
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
            String apellido = JOptionPane.showInputDialog("Ingrese los apellidos del propietario:");
            String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del propietario:");

            // Crear nombre completo del propietario
            String propietario = nombre + " " + apellido + " (ID: " + identificacion + ")";

            // Pedir datos del vehículo
            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");

            mensaje.append("Propietario: ").append(propietario).append("\n");
            mensaje.append("Placa: ").append(placa).append("\n");
            mensaje.append("Modelo: ").append(modelo).append("\n");

            // Elegir tipo de vehículo y crear instancia correspondiente
            String[] opciones = {"Carro", "Moto Clásica", "Moto Híbrida"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de vehículo:", "Tipo de Vehículo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            Vehiculo vehiculo = null;
//Opciones a elegir, si el vehiculo ingresado al parqueadero es un carro, una moto clasica o una moto hibrida
//ayuda con el break no entendi nada ;( 
            switch (opcion) {
                case 0:
                    mensaje.append("Tipo de vehículo: Carro\n");
                    vehiculo = new Carro(placa, modelo, propietario);
                    break;
                case 1:
                    mensaje.append("Tipo de vehículo: Moto Clásica\n");
                    String velocidadMaximaClasicaStr = JOptionPane.showInputDialog("Ingrese la velocidad máxima de la moto clásica:");
                    double velocidadMaximaClasica = Double.parseDouble(velocidadMaximaClasicaStr);
                    vehiculo = new Motoclasica(placa, modelo, propietario, velocidadMaximaClasica);
                    break;
                case 2:
                    mensaje.append("Tipo de vehículo: Moto Híbrida\n");
                    String velocidadMaximaHibridaStr = JOptionPane.showInputDialog("Ingrese la velocidad máxima de la moto híbrida:");
                    double velocidadMaximaHibrida = Double.parseDouble(velocidadMaximaHibridaStr);
                    vehiculo = new MotoHibrida(placa, modelo, propietario, velocidadMaximaHibrida);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }

            // Asignar puesto y registrar ingreso
            if (vehiculo != null) {
                Puesto puestoDisponible = parqueadero.obtenerPuestoDisponible();
                if (puestoDisponible != null) {
                    parqueadero.asignarPuesto(vehiculo);
                    mensaje.append("Puesto asignado: ").append(puestoDisponible.getPosicion());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay puestos disponibles para el vehículo con placa " + placa);
                }
            }
        }
        //mostrar toda la información recopilada, casi que no hago esto, alguien deberia de explicar como usar bien el JOptionPane youtube no cubre todas las dudas
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Información de Vehículos", JOptionPane.INFORMATION_MESSAGE);
    }
}