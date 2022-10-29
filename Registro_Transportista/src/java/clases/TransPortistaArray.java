/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransPortistaArray {
    
    TransPortistaModel[] clientTable;
    int indexArray;
    
    private Proyecto conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public TransPortistaArray (){
        clientTable = new  TransPortistaModel[100];
        this.indexArray = 0;
    }
    
public void saveClient( TransPortistaModel client){
        this.clientTable[this.indexArray] = client;
        this.indexArray = this.indexArray + 1;
    }
    
    public  TransPortistaModel[] getClient(){
        return clientTable;
    }
     
    public void deleteClient(String position){
          int pos = Integer.parseInt(position);
          this.clientTable[pos] = null;
          for(int i = pos; i < indexArray - 1; i++) {
                this.clientTable[i] = this.clientTable[i + 1];
          }
          this.clientTable[indexArray - 1] = null;
          indexArray --;
    }
    
    public void abrirConexion(){
        conectorBD= new Proyecto ();
        conexion=conectorBD.conectar();
    }

    public String guardarAlumno2( TransPortistaModel client){        
        String sql = "INSERT INTO transportes_ultrarrápidos_sa.transportista(Transportista,  Nombre, Apellido, Correo, Carné de conducir)  ";
             sql += " VALUES(  ?,?,?,?,?)"; 
        try{
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, client.getCode());
            statement.setString(2, client.getName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getEmail());
             statement.setString(5, client.getLicense());
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
        String sql="select * from transportes_ultrarrápidos_sa.transportista";
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
                     +" <script src=\"js/script.js\" type=\"text/javascript\"></script>"
                     );
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("Transportista")).append("</td>");
                respuesta.append("<td >").append(result.getString("Nombre")).append("</td>");
                respuesta.append("<td >").append(result.getString("Apellido")).append("</td>");
                respuesta.append("<td >").append(result.getString("Correo")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("Carné de conducir"))
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
    
  public String eliminarCliente(int carne){
        String sql = "DELETE FROM transportes_ultrarrápidos_sa.transportista WHERE Transportista = " + carne;
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