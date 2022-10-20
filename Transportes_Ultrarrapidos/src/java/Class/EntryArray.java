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
public class EntryArray {
    Entry[] entryRegister;
    int indexArray;
    
    private DatabasaConnection connectDB;
    private Connection connection;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    
    public EntryArray(){
        entryRegister = new Entry[100];
        this.indexArray = 0;
    }
    
    public void openConnection(){
        connectDB= new DatabasaConnection();
        connection=connectDB.connection();
    }
    
    public String registerEntry(Entry entry){        
        String sql = "INSERT INTO transportes_ultrarrapidos_sa.registro_ingreso(id_bodega, hora, dia, mes_anio, origen, tipo_carga) ";
             sql += " VALUES(  ?,?,?,?,?,?)"; 
        try{
            openConnection();
            statement = connection.prepareStatement(sql); 
            statement.setString(2, entry.getTime());
            statement.setInt(3, entry.getDay());
            statement.setString(4, entry.getMonthYear());
            statement.setString(5, entry.getOrigin());
            statement.setString(6, entry.getCargoType());
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
