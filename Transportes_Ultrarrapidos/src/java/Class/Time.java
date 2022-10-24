/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author ramir
 */
public class Time {
    Calendar calendar = Calendar.getInstance();
    int hour, minute, day, month, year;
    
        private DatabasaConnection connectDB;
    private Connection connection;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    
    public void openConnection(){
        connectDB= new DatabasaConnection();
        connection=connectDB.connection();
    }
    
    public String getTime(){
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.day = calendar.get(Calendar.DATE);
        this.month = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);
        String sql = "INSERT INTO transportes_ultrarrapidos_sa.registro_ingreso(hora, dia) ";
             sql += " VALUES(?, ?)"; 
        try{
            openConnection();
            statement = connection.prepareStatement(sql); 
            statement.setString(1, hour+":"+minute);
            statement.setString(2, day+"/"+month+"/"+year);
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
