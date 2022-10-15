/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hatziry Chacón
 */
public class DriverArray {

    Driver[] ArrayPiloto;
    int indice;
    private DriverDatabase conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public DriverArray() {
        this.ArrayPiloto = new Driver[100];
        this.indice = 0;
    }
    
    public void guardarRegistro(Driver piloto) {
        this.ArrayPiloto[indice] = piloto;
        this.indice = this.indice + 1;
        //Con este método logramos almacenar el registro en el array
    }
    
    public Driver[] returnCliente() {
        return this.ArrayPiloto;
        //Retornamos todo nuestro array
    }
    
    public void iniciarConexion() {
        conectorBD = new DriverDatabase();
        conexion = conectorBD.conectar();
    }
    
    public String guardarPilotoBD(Driver piloto) {
        String sql = "INSERT INTO transportes_ultrarrápidos_sa.piloto(id_dpi_Piloto, Nombre, Apellido, Telefono, Direccion)";
        sql += "VALUES (?,?,?,?,?)";
        
        try {
            iniciarConexion();
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, piloto.getDpi());
            statement.setString(2, piloto.getNombre());
            statement.setString(3, piloto.getApellido());
            statement.setInt(4, piloto.getTelefono());
            statement.setString(5, piloto.getDireccion());
            int resultado = statement.executeUpdate();
            // podemos colocar en vez de resultado el llamado de la función 
            // prstmt.executeUpdate() => if(prstmt.executeUpdate() > 0)
            if (resultado > 0) {
                return String.valueOf(resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public void getPiloto(StringBuffer respuesta) {
        String sql = "select * from transportes_ultrarrápidos_sa.piloto";
        try {
            iniciarConexion();
            respuesta.setLength(0);
            statement = conexion.prepareStatement(sql);
            result = statement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    respuesta.append("<tr>");
                    //nombre de los encabezados en las columnas del query en mySQL Workbench, deben estar todos en el mismo orden
                    respuesta.append("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n"
                            + "        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css\">\n"
                            + "        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>\n"
                            + "        <script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n"
                            + "        <script src=\"Js/DriverJs.js\" type=\"text/javascript\"></script>");
                    respuesta.append("<td >").append(result.getString("id_dpi_Piloto")).append("</td>");
                    respuesta.append("<td >").append(result.getString("Nombre")).append("</td>");
                    respuesta.append("<td >").append(result.getString("Apellido")).append("</td>");
                    respuesta.append("<td >").append(result.getString("Telefono")).append("</td>");
                    respuesta.append("<td >").append(result.getString("Direccion")).append("</td>");
                    respuesta.append("<td id=\"").append(result.getString("id_dpi_Piloto"))
                            .append("\"  onclick=\"eliminar(this.id);\">")
                            .append(" <a class=\"btn btn-warning\"'><i class=\"bi bi-vector-pen\"></i>  </a>"
                                    + " <a class=\"btn btn-danger\"'> <i class=\"bi bi-trash3\"></i> </a>"
                                    + " <td></tr>");
                }
            } else {
                respuesta.append("error al consultar");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public String eliminarPiloto(int dpi) {
        String sql = "DELETE FROM piloto WHERE id_dpi_Piloto=" + dpi;
        try {
            iniciarConexion();
            statement = conexion.prepareStatement(sql);
            int resultado = statement.executeUpdate();
            if (resultado > 0) {
                return String.valueOf(resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
