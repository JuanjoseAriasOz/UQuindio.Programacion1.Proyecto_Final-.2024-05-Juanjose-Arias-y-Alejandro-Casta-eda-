package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

/**
 *Clase padre "Vehiculo" que heradara a sus hijos Carro, Moto y MotoHibrida
 */
 public class Vehiculo {
     private String placa;
     private String modelo;
     private String propietario;
     private LocalDateTime horaEntrada;
     private LocalDateTime horaSalida;
 
     public Vehiculo(String placa, String modelo, String propietario) {
         this.placa = placa;
         this.modelo = modelo;
         this.propietario = propietario;
     }
 
     public String getPlaca() {
         return placa;
     }
 
     public String getModelo() {
         return modelo;
     }
 
     public String getPropietario() {
         return propietario;
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

    public Object getgananciasCarro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getgananciasCarro'");
    }

    public Object getgananciasmotoclasica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getgananciasmotoclasica'");
    }

    public Object getgananciasmotoHibrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getgananciasmotoHibrida'");
    }
 }
 
