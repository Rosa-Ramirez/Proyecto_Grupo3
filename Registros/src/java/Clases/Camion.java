/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Camion{
    private String Placa;
    private String Matricula;
    private String Modelo;
    private String Capacidad_peso;
    private String Hora;
   
    
    public Camion(String Placa, String Matricula, String Modelo, String Capacidad_peso, String Hora){
    this.Placa = Placa;
    this.Matricula=Matricula;
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

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
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
