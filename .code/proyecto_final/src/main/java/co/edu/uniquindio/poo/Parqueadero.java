package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Parqueadero {
    private String nombre;
    //almacena el nombre del parqueadero.
    private static Puesto[][] puestos; 
    //para almacenar los puestos.
    private static List<Vehiculo> vehiculos; 
    private double gananciasDiarias;
    //almacenará las ganancias acumuladas por días.
    private double gananciasMensuales;
    // almacenará las ganancias acumuladas por meses.
    private double gananciasCarros;
    //almacenará las ganancias acumuladas por las motos clasicas estacionadas en el parqueadero.
    private double gananciasMotosClasicas;
    // almacenará las ganancias acumuladas por las motos híbridas estacionadas en el parqueadero.
    private double gananciasMotosHibridas;
    //Esto se utiliza para realizar un seguimiento de qué vehículo está estacionado en qué posición del parqueadero.
    private static Map<String, Vehiculo> posicionVehiculos; 

    //constructor de la clase parqueadero
    public Parqueadero(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        puestos = new Puesto[filas][columnas];
        vehiculos = new ArrayList<>();
        this.gananciasDiarias = 0;
        this.gananciasMensuales = 0;
        this.gananciasCarros = 0;
        this.gananciasMotosClasicas = 0;
        this.gananciasMotosHibridas = 0;
        //para mapear las posiciones de los puestos del parqueadero a los vehículos estacionados en esos puestos.
        posicionVehiculos = new HashMap<>();

        assert nombre != null && !nombre.isBlank();
        assert filas > 0;
        assert columnas > 0 ;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //Para crear un nuevo puesto.
                puestos[i][j] = new Puesto("Puesto " + (i + 1) + "-" + (j + 1), false);
            }
        }
    }
    //metodo para obtener el nombre
    public String getNombre() {
        return nombre;
    }
    //metodo para agregar un puesto
    public void agregarPuesto(Puesto puesto, int i, int j) {
        puestos[i][j] = puesto;
    }
    //metodo para registrar el vehivulo
    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
    //metodo para obtener Un puesto
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
    //metodo para asignar un puesto.
    public void asignarPuesto(Vehiculo vehiculo, int tiempoEstadia, double tarifaPorHora) {
        Puesto puestoDisponible = obtenerPuestoDisponible();
        if (puestoDisponible != null) {
            puestoDisponible.ocuparPuesto();
            registrarVehiculo(vehiculo);
            vehiculo.setHoraEntrada(LocalDateTime.now());
            double tarifaTotal = tiempoEstadia * tarifaPorHora;
            this.gananciasDiarias += tarifaTotal;
            //instanciar los vehiculos para poderlos asignar a un lugar
            if (vehiculo instanceof Carro) {
                this.gananciasCarros += tarifaTotal;
            } else if (vehiculo instanceof Motoclasica) {
                this.gananciasMotosClasicas += tarifaTotal;
            } else if (vehiculo instanceof MotoHibrida) {
                this.gananciasMotosHibridas += tarifaTotal;
            }

            String posicion = puestoDisponible.getPosicion();
            posicionVehiculos.put(posicion, vehiculo);
    //mensaje que contiene la placa del vehivulo diciendo que ha sido asignado a cierto puesto.
            System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha sido asignado al puesto " + posicion);
        } else {
            System.out.println("No hay puestos disponibles.");
        }
    }
    //metodo para decir que un vehiculo ha salido de cierto puesto.
    public static void asignarPuesto(Vehiculo vehiculo) {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (puestos[i][j].getOcupado() && vehiculos.contains(vehiculo)) {
                    puestos[i][j].desocuparPuesto();
                    vehiculo.setHoraSalida(LocalDateTime.now());
                    String posicion = puestos[i][j].getPosicion();
                    posicionVehiculos.remove(posicion);
                    System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " ha salido del puesto " + posicion);
                    return;
                }
            }
        }
    }
    //simular un cambio de dia para hacer más facil el calculo de las ganacias
    public void cambiarDia() {
        this.gananciasMensuales += this.gananciasDiarias;
        this.gananciasDiarias = 0;
    }
    //mostrar las ganacias Diarias,Mensuales y por tipos de vehiculos.
    public void mostrarGanancias(StringBuilder mensaje) {
        mensaje.append("Ganancias Diarias: ").append(this.gananciasDiarias).append("\n");
        mensaje.append("Ganancias Mensuales: ").append(this.gananciasMensuales).append("\n");
        mensaje.append("Ganancias por Carros: ").append(this.gananciasCarros).append("\n");
        mensaje.append("Ganancias por Motos Clásicas: ").append(this.gananciasMotosClasicas).append("\n");
        mensaje.append("Ganancias por Motos Híbridas: ").append(this.gananciasMotosHibridas).append("\n");
    }
    //para devolver una lista de los vehiculos estacionados.
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
    //para devolver un vehiculo que este estacionado en un puesto.
    public Vehiculo obtenerVehiculoEnPuesto(String posicion) {
        return posicionVehiculos.get(posicion);
    }
    
    //inicializando la matriz para poder asignar los vehiculos a la matriz.
    public static void main(String[] args) {
        int filas = 5;
        int columnas = 5;
        Parqueadero parqueadero = new Parqueadero("Mi Parqueadero", filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                parqueadero.agregarPuesto(new Puesto("Puesto " + (i + 1) + "-" + (j + 1), false), i, j);
            }
        }
        //mensaje de bienvenida.
        JOptionPane.showMessageDialog(null, "¡Bienvenido a Mi Parqueadero!", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
        //pregunta de cuantos vehiculos desea el usuario ingresar al parqueadero.
        String numeroVehiculosStr = JOptionPane.showInputDialog("Ingrese el número de vehículos que desea ingresar:");
        int numeroVehiculos = Integer.parseInt(numeroVehiculosStr);

        StringBuilder mensaje = new StringBuilder();

        for (int i = 0; i < numeroVehiculos; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
            String apellido = JOptionPane.showInputDialog("Ingrese los apellidos del propietario:");
            String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del propietario:");

            String propietario = (nombre + " " + apellido + " ID: " + identificacion);

            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");

            mensaje.append("Propietario: ").append(propietario).append("\n");
            mensaje.append("Placa: ").append(placa).append("\n");
            mensaje.append("Modelo: ").append(modelo).append("\n");
            String[] opciones = {"Carro", "Moto Clásica", "Moto Híbrida"};
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de vehículo:", "Tipo de Vehículo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            //mensaje que le pregunatara al usuario que tipo de vehiculo va a ingresar.
            Vehiculo vehiculo = null;
            double tarifaPorHora = 0;
            switch (opcion) {
                case 0:
                    mensaje.append("Tipo de vehículo: Carro\n");
                    vehiculo = new Carro(placa, modelo);
                    tarifaPorHora = 8500;
                    break;
                case 1:
                    mensaje.append("Tipo de vehículo: Moto Clásica\n");
                    String velocidadMaximaClasicaStr = JOptionPane.showInputDialog("Ingrese la velocidad máxima de la moto clásica:");
                    vehiculo = new Motoclasica(placa, modelo, Double.parseDouble(velocidadMaximaClasicaStr));
                    tarifaPorHora = 6000;
                    break;
                case 2:
                    mensaje.append("Tipo de vehículo: Moto Híbrida\n");
                    String velocidadMaximaHibridaStr = JOptionPane.showInputDialog("Ingrese la velocidad máxima de la moto híbrida:");
                    vehiculo = new MotoHibrida(placa, modelo, Double.parseDouble(velocidadMaximaHibridaStr));
                    tarifaPorHora = 7500;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
            //mensaje que le preguntara la velocidad maxima al usuario, si este ingresa una motohibrida o una motoclasica
            if (vehiculo instanceof Motoclasica) {
                mensaje.append("Velocidad Máxima: ").append(((Motoclasica) vehiculo).getVelocidadMaxima()).append(" km/h\n");
            } else if (vehiculo instanceof MotoHibrida) {
                mensaje.append("Velocidad Máxima: ").append(((MotoHibrida) vehiculo).getVelocidadMaxima()).append(" km/h\n");
            }

            String tiempoEstadiaStr = JOptionPane.showInputDialog("Ingrese el tiempo de estadía en horas:");
            int tiempoEstadia = Integer.parseInt(tiempoEstadiaStr);

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
        //mensaje que muestrala informació del vehiculo y el propietario,
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Información de Vehículos", JOptionPane.INFORMATION_MESSAGE);
        //mensaje que muestra las ganancias
        StringBuilder gananciasMensaje = new StringBuilder();
        parqueadero.mostrarGanancias(gananciasMensaje);
        JOptionPane.showMessageDialog(null, gananciasMensaje.toString(), "Ganancias", JOptionPane.INFORMATION_MESSAGE);

        parqueadero.cambiarDia();

        parqueadero.mostrarGanancias(gananciasMensaje);
        JOptionPane.showMessageDialog(null, gananciasMensaje.toString(), "Ganancias después del cambio de día", JOptionPane.INFORMATION_MESSAGE);
        //mensaje para preguntar si quiere verificar las posicciones de algún vehiculo.
        int verificarPuesto = JOptionPane.showConfirmDialog(null, "¿Desea verificar las posiciones ocupadas?", "Verificar Posiciones", JOptionPane.YES_NO_OPTION);
        if (verificarPuesto == JOptionPane.YES_OPTION) {
            StringBuilder posicionesOcupadas = new StringBuilder("Posiciones ocupadas:\n");
            for (String posicion : Parqueadero.posicionVehiculos.keySet()) {
                posicionesOcupadas.append(posicion).append("\n");
            }
            JOptionPane.showMessageDialog(null, posicionesOcupadas.toString(), "Posiciones Ocupadas", JOptionPane.INFORMATION_MESSAGE);
               //pregunta de si algún vehiculo desea salir del parqueadero.
            int deseaSalir = JOptionPane.showConfirmDialog(null, "¿Algún vehículo desea salir del parqueadero?", "Salir del Parqueadero", JOptionPane.YES_NO_OPTION);
            if (deseaSalir == JOptionPane.YES_OPTION) {
                // Mostrar la lista de vehículos estacionados
                StringBuilder vehiculosEstacionados = new StringBuilder("Vehículos Estacionados:\n");
                for (int i = 0; i < Parqueadero.vehiculos.size(); i++) {
                    vehiculosEstacionados.append(i + 1).append(". ").append(Parqueadero.vehiculos.get(i).getPlaca()).append("\n");
                }
                String opcionSalidaStr = JOptionPane.showInputDialog(null, vehiculosEstacionados.toString() + "\nIngrese el número del vehículo que desea sacar del parqueadero:", "Salir del Parqueadero", JOptionPane.PLAIN_MESSAGE);
                int opcionSalida = Integer.parseInt(opcionSalidaStr);
        
                // Verificar si la opción ingresada es válida
                if (opcionSalida >= 1 && opcionSalida <= Parqueadero.vehiculos.size()) {
                    Vehiculo vehiculoSalida = Parqueadero.vehiculos.get(opcionSalida - 1);
                    Parqueadero.asignarPuesto(vehiculoSalida);
                    //metodo para remover un vehiculo del parqueadero
                    Parqueadero.vehiculos.remove(vehiculoSalida); 
                    JOptionPane.showMessageDialog(null, "El vehículo con placa " + vehiculoSalida.getPlaca() + " ha salido del parqueadero.", "Salida Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese un número de vehículo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}        

//ayuda con los joptioPane :(
//Creditos al profe manuel por las ideas de los JOptionPane.
//Sacamos mucha información de internet, sobre todo youtube👍＞﹏＜