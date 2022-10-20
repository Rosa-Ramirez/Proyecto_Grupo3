/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
/**
 *
 * @author Fernanda Cordón
 */
public class ConexionBaseDeDatos {
    
    private final String url="jdbc:mysql://localhost:3306/transportes_ultrarrápidos_sa";//url de MySQL
    private final String usuario="Romeo";
    private final String clave="";
    Connection conexion=null;  
    public Connection conectar(){
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection( url, usuario,clave);
        }  catch (SQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }         
        return conexion;        
    }
    
}
