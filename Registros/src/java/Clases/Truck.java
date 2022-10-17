/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Truck{
    private String Placa;
    private int id_Transportista;
    private String Modelo;
    private String Capacidad_peso;
    private String Hora;
   
    
    public Truck(String Placa, String Modelo, String Capacidad_peso, String Hora){
    this.Placa = Placa;
    
    this.Modelo = Modelo;
    this.Capacidad_peso = Capacidad_peso;
    this.Hora = Hora;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getTransportista() {
        return id_Transportista;
    }

    public void setTransportista(int id_Transportista) {
        this.id_Transportista = id_Transportista;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }
    
    public String getCapacidad() {
        return Capacidad_peso;
    }

    public void setCapacidad(String Capacidad_peso) {
        this.Capacidad_peso = Capacidad_peso;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    
}
