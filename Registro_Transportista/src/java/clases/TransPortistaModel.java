/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class TransPortistaModel{
    private int code;
    private String name;
    private String lastName;
    private String email;
    private String license;
    
    public  TransPortistaModel(int code,  String name, String lastName,  String email,  String license){
    this.code = code;
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.license=license;
    }

   

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


   
    
}
