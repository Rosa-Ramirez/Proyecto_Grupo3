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
public class EgressArray {
    Egress[] egressRegistry;
    int indexArray;
    
    private DatabasaConnection connectDB;
    private Connection connection;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    
    public EgressArray(){
        egressRegistry = new Egress[100];
        this.indexArray = 0;
    }
    
    public void openConnection(){
        connectDB= new DatabasaConnection();
        connection=connectDB.connection();
    }
    
    public String registerEgress(Egress egress){        
        String sql = "INSERT INTO transportes_ultrarrapidos_sa.registro_egreso( id_bodega, hora, dia, mes_anio, destino, tipo_carga) ";
             sql += " VALUES(  ?,?,?,?,?,?)"; 
        try{
            openConnection();
            statement = connection.prepareStatement(sql); 
            statement.setString(1, egress.getDepot());
            statement.setString(2, egress.getTime());
            statement.setInt(3, egress.getDay());
            statement.setString(4, egress.getMonthYear());
            statement.setString(5, egress.getDestiny());
            statement.setString(6, egress.getCargoType());
            
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
        public String deleteEgress(int idEgress){
        String sql = "DELETE FROM registro_egreso WHERE id_registro_egreso = "+idEgress;
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