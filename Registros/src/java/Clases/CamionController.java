/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CamionController {
    
     Camion[] clientTable;
      int indexArray;
    
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public CamionController(){
        clientTable = new Camion[100];
        this.indexArray = 0;
    }
    

    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }
    
    public String guardarAlumno2(Camion camion){        
        String sql = "INSERT INTO transportes_ultrarrapidos_sa.camion(placa, matricula, modelo, capacidad_peso, hora)  ";
             sql += " VALUES(  ?,?,?,?,?)"; 
        try{
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setString(1, camion.getPlaca());
            statement.setString(2, camion.getMatricula());
            statement.setString(3, camion.getModelo());
            statement.setString(4, camion.getCapacidad());
            statement.setString(5, camion.getHora());
            int resultado = statement.executeUpdate(); 
            
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){
            return e.getMessage();
        }    
    }
    
    public void getClient2(StringBuffer respuesta){   
        String sql="select * from transportes_ultrarrápidos_sa.camion";
        try{
        abrirConexion();
        respuesta.setLength(0);
                
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if (result!=null){
                while (result.next()){
                respuesta.append("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n" +
                     "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>"
                     +"<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>"
                     +"<script src='js/script.js'></script>"
                     );
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("Placa")).append("</td>");
                respuesta.append("<td >").append(result.getString("Matricula")).append("</td>");
                respuesta.append("<td >").append(result.getString("Modelo")).append("</td>");
                respuesta.append("<td >").append(result.getString("Capacidad_peso")).append("</td>");
                respuesta.append("<td >").append(result.getString("Hora")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("Placa"))
                        .append("\"  onclick=\"eliminarAlumno(this.id);\">") 
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public String eliminarAlumno(int idRegister){
        String sql = "DELETE FROM Placa WHERE Placa = "+idRegister;
        try{
            abrirConexion();
            statement = conexion.prepareStatement(sql);
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){
                    return e.getMessage();
                    }
    }
}

