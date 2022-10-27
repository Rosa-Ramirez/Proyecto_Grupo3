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
public class EntryArray extends Time{
    Entry[] entryRegister;
    int indexArray;
    Time time;
    
//    private DatabasaConnection connectDB;
    private Connection connection;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    
    public EntryArray(){
        entryRegister = new Entry[100];
        this.indexArray = 0;
    }
    
    public String registerEntry(Entry entry){        
        String sql = "INSERT INTO transportes_ultrarrapidos_sa.registro_ingreso(id_bodega, hora, dia, origen, tipo_carga) ";
             sql += " VALUES(  ?,?,?, ?, ?)"; 
        try{
            openConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(2, hour+":"+minute);
            statement.setString(3, day+"/"+month+"/"+year);
            statement.setString(4, entry.getOrigin());
            statement.setString(5, entry.getCargoType());
            statement.setString(1, entry.getDepot());
            
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
    
        public String deleteEntry(int idRegister){
        String sql = "DELETE FROM registro_ingreso WHERE id_registro_ingreso = "+idRegister;
        try{
            openConnection();
            statement = connection.prepareStatement(sql);
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
