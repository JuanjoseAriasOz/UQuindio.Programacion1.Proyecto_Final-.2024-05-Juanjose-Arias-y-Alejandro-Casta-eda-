package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

/**
 *Clase padre "Vehiculo" que heradara a sus hijos Carro, Moto y MotoHibrida
 */
 public class Vehiculo {
     private String placa;
     private String modelo;
     
     private LocalDateTime horaEntrada;
     private LocalDateTime horaSalida;
 
     public Vehiculo(String placa, String modelo) {
         this.placa = placa;
         this.modelo = modelo;
     }
 
     public String getPlaca() {
         return placa;
     }
 
     public String getModelo() {
         return modelo;
     }
 
     public LocalDateTime getHoraEntrada() {
         return horaEntrada;
     }
 
     public void setHoraEntrada(LocalDateTime horaEntrada) {
         this.horaEntrada = horaEntrada;
     }
 
     public LocalDateTime getHoraSalida() {
         return horaSalida;
     }
 
     public void setHoraSalida(LocalDateTime horaSalida) {
         this.horaSalida = horaSalida;
     }
 }
 
