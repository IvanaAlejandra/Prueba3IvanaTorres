/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.Dueno;
/**
 *
 * @author PAAPCA02LC0828
 */
public class DuenoDAO {
    private String url = "jdbc:mysql://localhost:3306/tienda";
    private String user = "root";
    private String pass = " ";
    
    //conexion bd
    
   public Connection conectar() throws SQLException {
       return DriverManager.getConnection(url, user, pass);
   }
   
   //craer un dueño
   public boolean agregarDueno(Dueno due) {
        String query = "INSERT INTO dueno (rut,nombre,apellido,telefono,edad) VALUES (?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, due.getRut());
            stmt.setString(2, due.getNombre());
            stmt.setString(3, due.getApellido());
            stmt.setString(4, due.getTelefono());
            stmt.setInt(5, due.getEdad());
            return stmt.executeUpdate() > 0;
        } catch(SQLException e) {
            return false;
        }
    }
    
    // modificar un dueno
    public boolean modificarDueno(Dueno due) {
        String query = "UPDATE dueno SET rut=?, nombre=?, apellido=?, telefono=?, edad=? WHERE rut=?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, due.getRut());
            stmt.setString(2, due.getNombre());
            stmt.setString(3, due.getApellido());
            stmt.setString(4, due.getTelefono());
            stmt.setInt(5, due.getEdad());
            return stmt.executeUpdate() > 0;
        } catch(SQLException e) {
            return false;
        }
    }
    
    // eliminar un dueno
    public boolean eliminarDueno(int rut) {
        String query = "DELETE FROM dueno WHERE rut=?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, rut);
            return stmt.executeUpdate() > 0;
        } catch(SQLException e) {
            return false;
        }
    }
    
    // listar dueno
    public List<Dueno> listarDueno() {
        List<Dueno> lista = new ArrayList<>();
        String query = "SELECT * FROM dueno";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {  
               lista.add(new Dueno(
                       rs.getString("rut"),
                       rs.getString("nombre"),
                       rs.getString("apellido"),                       
                       rs.getString("telefono"),
                       rs.getInt("edad")
               ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
   
