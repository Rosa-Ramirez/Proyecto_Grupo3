/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ramir
 */
public class User {
    
        private DatabasaConnection connectDB;
        private Connection connection;
        private PreparedStatement statement = null;
        private ResultSet resultSet = null;
    
    
        public User(){
            this.connectDB = new DatabasaConnection();
        }
        
       public String userValidation(String user, String pass){
        //SE VALIDA EL USUARIO EN LA BD
       String sql = "SELECT * FROM usuario WHERE usuario = ' " + user + " ' AND contrasenia = ' " + pass + " ' ";
       
       try{
           this.connection = this.connectDB.connection();
           this.statement = connection.prepareStatement(sql);
           this.resultSet = this.statement.executeQuery();
           
           if(resultSet != null){
               
               String userFound = " ";
               while(resultSet.next()){
                   userFound = resultSet.getString("user");
                   
               }
               
               return userFound;
           }
           
           return "Usuario no encontrado";
       }
       
       catch(SQLException e){
           return e.getMessage();
       }
}
}
