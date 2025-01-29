/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.Dueno;
import modelo.dto.Mascota;

/**
 *
 * @author PAAPCA02LC0828
 */
public class MascotaDAO {
    private String url = "jdbc:mysql://localhost:3306/tienda";
    private String user = "root";
    private String pass = " ";
    
    //conexion bd
    
   public Connection conectar() throws SQLException {
       return DriverManager.getConnection(url, user, pass);
   }
   
   //craer mascota
   public boolean agregarMascota(Mascota masc) {
        String query = "INSERT INTO mascota (chip,rut_dueno,nombre_mascota,fecha_nacimiento,edad) VALUES (?,?,?,?,?)";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, masc.getChip());            
            stmt.setString(2, masc.getDueno().getRut());
            stmt.setString(3, masc.getNombreMascota());
            stmt.setString(4, masc.getFechaNacimiento());
            stmt.setInt(5, masc.getEdad());
            return stmt.executeUpdate() > 0;
        } catch(SQLException e) {
            return false;
        }
    }
    
    // modificar un mascota
    public boolean modificarMascota(Mascota masc) {
        String query = "UPDATE mascota SET chip=?, rut_dueno=?, nombre_mascota=?, fecha_nacimiento=?, edad=? WHERE chip=?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, masc.getChip());            
            stmt.setString(2, masc.getDueno().getRut());
            stmt.setString(3, masc.getNombreMascota());
            stmt.setString(4, masc.getFechaNacimiento());
            stmt.setInt(5, masc.getEdad());
            return stmt.executeUpdate() > 0;
        } catch(SQLException e) {
            return false;
        }
    }
    
    // eliminar mascota
    public boolean eliminarMascota(String chip) {
        String query = "DELETE FROM mascota WHERE chip=?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, chip);
            return stmt.executeUpdate() > 0;
        } catch(SQLException e) {
            return false;
        }
    }
    
    // listar mascota
    public List<Mascota> listarMascota() {
        List<Mascota> lista = new ArrayList<>();
        String query = "SELECT * FROM mascota";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()) {  
               lista.add(new Mascota(
                       rs.getString("chip"),
                       rs.getString("rut_dueno"),
                       rs.getString("apellido"),                       
                       rs.getString("telefono"),
                       rs.getInt("edad"),
                       new Dueno(rs.getInt("dueno"))
               ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
