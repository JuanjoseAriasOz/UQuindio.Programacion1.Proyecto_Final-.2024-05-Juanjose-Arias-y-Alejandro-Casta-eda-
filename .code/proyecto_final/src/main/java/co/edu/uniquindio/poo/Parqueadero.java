package co.edu.uniquindio.poo;

import java.util.LinkedList;
import java.util.Collection;


/**
 * clase principal Parqueadero, que contendra los puestos que a su vez contendran los vehiculos
 */
    public class Parqueadero {
        // Atributos
        private String[][] posiciones;
        private boolean[][] ocupados;
    
        // Constructor
        public Parqueadero() {
            this.posiciones = new String[5][5];
            this.ocupados = new boolean[5][5];
        }
    
        // Método para agregar un vehículo
        public boolean agregarVehiculo(int fila, int columna, String vehiculo) {
            if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
                throw new IllegalArgumentException("Posición fuera de los límites.");
            }
            if (ocupados[fila][columna]) {
                return false; // La posición está ocupada
            }
            posiciones[fila][columna] = vehiculo;
            ocupados[fila][columna] = true;
            return true; // Vehículo agregado exitosamente
        }
    
        // Método para verificar si una posición está ocupada
        public boolean estaOcupado(int fila, int columna) {
            if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
                throw new IllegalArgumentException("Posición fuera de los límites.");
            }
            return ocupados[fila][columna];
        }
    
        // Método para obtener el estado del parqueadero
        public void mostrarEstado() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print((ocupados[i][j] ? "O" : "L") + " ");
                }
                System.out.println();
            }
        }
    
        public static void main(String[] args) {
            Parqueadero parqueadero = new Parqueadero();
            parqueadero.agregarVehiculo(2, 3, "Carro1");
            parqueadero.mostrarEstado();
        }
    }