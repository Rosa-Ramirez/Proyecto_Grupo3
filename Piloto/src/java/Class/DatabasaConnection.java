/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hatziry Chacón
 */
class DatabasaConnection {
    protected String url="jdbc:mysql://localhost:3306/transportes_ultrarrapidos_sa";//url de MySQL
    private final String usuario="root";
    private final String clave="root"; //MySQLServer_Rouss154!
    Connection conn=null;  
    public Connection connection(){
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection( url, usuario,clave);
        }  catch (SQLException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }         
        return conn;        
    }
}
