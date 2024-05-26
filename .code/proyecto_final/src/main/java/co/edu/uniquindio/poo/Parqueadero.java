package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
//definición de la matriz para poder hacer los puestos.
public class Parqueadero {
    private String nombre;
    //crear la matriz para hacer los puesto.
    private Puesto[][] puestos; 
    //crear una lista de vehiculos.
    private List<Vehiculo> vehiculos;
    //definimos las variables para poder calcular las ganancias.
    private double gananciasDiarias;
    private double gananciasMensuales;
    private double gananciasCarros;
    private double gananciasMotosClasicas;
    private double gananciasMotosHibridas;

    public Parqueadero(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.puestos = new Puesto[filas][columnas];
        this.vehiculos = new ArrayList<>();
        this.gananciasDiarias = 0;
        this.gananciasMensuales = 0;
        this.gananciasCarros = 0;
        this.gananciasMotosClasicas = 0;
        this.gananciasMotosHibridas = 0;

// Inicializar la matriz de puestos con puestos vacíos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto("Puesto " + (i + 1) + "-" + (j + 1), false);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPuesto(Puesto puesto, int i, int j) {
        puestos[i][j] = puesto;
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Puesto obtenerPuestoDisponible() {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (!puestos[i][j].getOcupado()) {
                    return puestos[i][j];
                }
            }
        }
        return null;
    }
//Metodo para asignar un puesto al vehiculo entrante.
    public void asignarPuesto(Vehiculo vehiculo, int tiempoEstadia, double tarifaPorHora) {
        Puesto puestoDisponible = obtenerPuestoDisponible();
        if (puestoDisponible != null) {
            puestoDisponible.ocuparPuesto();
            registrarVehiculo(vehiculo);
            vehiculo.setHoraEntrada(LocalDateTime.now());
            double tarifaTotal = tiempoEstadia * tarifaPorHora;
            this.gananciasDiarias += tarifaTotal;

            if (vehiculo instanceof Carro) {
                this.gananciasCarros += tarifaTotal;
            } else if (vehiculo instanceof Motoclasica) {
                this.gananciasMotosClasicas += tarifaTotal;
            } else if (vehiculo instanceof MotoHibrida) {
                this.gananciasMotosHibridas += tarifaTotal;
            }

            System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha sido asignado al puesto " + puestoDisponible.getPosicion());
        } else {
            System.out.println("No hay puestos disponibles.");
        }
    }

    public void asignarPuesto(Vehiculo vehiculo) {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (puestos[i][j].getOcupado() && vehiculos.contains(vehiculo)) {
                    puestos[i][j].desocuparPuesto();
                    vehiculo.setHoraSalida(LocalDateTime.now());
                    System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha salido del puesto " + puestos[i][j].getPosicion());
                    return;
                }
            }
        }
    }
//metodo de las ganancias diraias, la incialice en 0.
    public void cambiarDia() {
        this.gananciasMensuales += this.gananciasDiarias;
        this.gananciasDiarias = 0;
    }
//metodo para mostrar las ganancias diarias, mensuales, y por el tipo de vehiculo ingresado en el parqueadero.
    public void mostrarGanancias(StringBuilder mensaje) {
        mensaje.append("Ganancias Diarias: ").append(this.gananciasDiarias).append("\n");
        mensaje.append("Ganancias Mensuales: ").append(this.gananciasMensuales).append("\n");
        mensaje.append("Ganancias por Carros: ").append(this.gananciasCarros).append("\n");
        mensaje.append("Ganancias por Motos Clásicas: ").append(this.gananciasMotosClasicas).append("\n");
        mensaje.append("Ganancias por Motos Híbridas: ").append(this.gananciasMotosHibridas).append("\n");
    }
//metodo para devolver la lista de vehiculos
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    public static void main(String[] args) {
        //inicializamos la matriz con los numeros que queramos en mi caso la puse de 5*5
        int filas = 5; 
        int columnas = 5; 
        Parqueadero parqueadero = new Parqueadero("Mi Parqueadero", filas, columnas);

        // Crear y agregar puestos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                parqueadero.agregarPuesto(new Puesto("Puesto " + (i + 1) + "-" + (j + 1), false), i, j);
            }
        }
        //mensaje de bienvenida. 
        JOptionPane.showMessageDialog(null, "¡Bienvenido a Mi Parqueadero!", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);

        // Preguntar cuántos vehículos se desean ingresar al parqueadero
        String numeroVehiculosStr = JOptionPane.showInputDialog("Ingrese el número de vehículos que desea ingresar:");
        int numeroVehiculos = Integer.parseInt(numeroVehiculosStr);

        StringBuilder mensaje = new StringBuilder();

        for (int i = 0; i < numeroVehiculos; i++) {
            // Pedir datos del propietario
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
            String apellido = JOptionPane.showInputDialog("Ingrese los apellidos del propietario:");
            String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del propietario:");

            // Crear nombre completo del propietario
            String propietario = (nombre +""+ apellido + " ID: " + identificacion + "");

            // Pedir datos del vehículo
            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");

            mensaje.append("Propietario: ").append(propietario).append("\n");
            mensaje.append("Placa: ").append(placa).append("\n");
            mensaje.append("Modelo: ").append(modelo).append("\n");

            // Elegir tipo de vehículo
            String[] opciones = {"Carro", "Moto Clásica", "Moto Híbrida"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de vehículo:", "Tipo de Vehículo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            Vehiculo vehiculo = null;
            double tarifaPorHora = 0;
            switch (opcion) {
                case 0:
                    mensaje.append("Tipo de vehículo: Carro\n");
                    vehiculo = new Carro(placa, modelo, propietario);
                    //valor de la tarifa que decidamos poner.
                    tarifaPorHora = 8500;
                    break;
                case 1:
                    mensaje.append("Tipo de vehículo: Moto Clásica\n");
                    String velocidadMaximaClasicaStr = JOptionPane.showInputDialog("Ingrese la velocidad máxima de la moto clásica:");
                    vehiculo = new Motoclasica(placa, modelo, propietario, Double.parseDouble(velocidadMaximaClasicaStr));
                    //valor de la tarifa que decidamos poner.
                    tarifaPorHora = 6000;
                    break;
                case 2:
                    mensaje.append("Tipo de vehículo: Moto Híbrida\n");
                    String velocidadMaximaHibridaStr = JOptionPane.showInputDialog("Ingrese la velocidad máxima de la moto híbrida:");
                    vehiculo = new MotoHibrida(placa, modelo, propietario, Double.parseDouble(velocidadMaximaHibridaStr));
                    //valor de la tarifa que decidamos poner.
                    tarifaPorHora = 7500;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
            
            if (vehiculo instanceof Motoclasica) {
                mensaje.append("Velocidad Máxima: ").append(((Motoclasica) vehiculo).getVelocidadMaxima()).append(" km/h\n");
            } else if (vehiculo instanceof MotoHibrida) {
                mensaje.append("Velocidad Máxima: ").append(((MotoHibrida) vehiculo).getVelocidadMaxima()).append(" km/h\n");
            }
            
            // Pedir tiempo de estadía
            String tiempoEstadiaStr = JOptionPane.showInputDialog("Ingrese el tiempo de estadía en horas:");
            int tiempoEstadia = Integer.parseInt(tiempoEstadiaStr);

            // Asignar puesto y registrar ingreso
            if (vehiculo != null) {
                Puesto puestoDisponible = parqueadero.obtenerPuestoDisponible();
                if (puestoDisponible != null) {
                    parqueadero.asignarPuesto(vehiculo, tiempoEstadia, tarifaPorHora);
                    mensaje.append("Puesto asignado: ").append(puestoDisponible.getPosicion()).append("\n");
                    mensaje.append("Hora de entrada: ").append(vehiculo.getHoraEntrada()).append("\n");
                    mensaje.append("Tiempo de estadía: ").append(tiempoEstadia).append(" horas\n");
                    mensaje.append("Tarifa total: ").append(tiempoEstadia * tarifaPorHora).append(" Pesos\n\n");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay puestos disponibles para el vehículo con placa " + placa);
                }
            }
        }

        // Mostrar toda la información recopilada de los propietarios y su vehiculo ingresado
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Información de Vehículos", JOptionPane.INFORMATION_MESSAGE);

        // Mostrar ganancias diarias y mensuales
        StringBuilder gananciasMensaje = new StringBuilder();
        parqueadero.mostrarGanancias(gananciasMensaje);
        JOptionPane.showMessageDialog(null, gananciasMensaje.toString(), "Ganancias", JOptionPane.INFORMATION_MESSAGE);

        // Simular cambio de día para poder hacer algo más gomelo :) 
        parqueadero.cambiarDia();

        // Mostrar ganancias diarias y mensuales después del cambio de día
        parqueadero.mostrarGanancias(gananciasMensaje);
        JOptionPane.showMessageDialog(null, gananciasMensaje.toString(), "Ganancias después del cambio de día", JOptionPane.INFORMATION_MESSAGE);
    }
}
