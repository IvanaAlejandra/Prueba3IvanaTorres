/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.Usuario;
/**
 *
 * @author PAAPCA02LC0828
 */
public class UsuarioDAO {
    //conexion a la bd
    private String url = "jdbc:mysql://localhost:3306/veterinaria";
    private String user = "root";
    private String pass = "";
    
    
    //metodo para conectar la bd
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url,user,pass);
    }
    
    //metodo para registrar usuario
    public boolean registrarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios(usuario, contraseña) VALUES (?,?)";
        try (Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2,usuario.getContrasena());
            stmt.executeUpdate();
            return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
        return false;
    }
    //metodo para validar Login
    public boolean autenticarUsuario(String usuario, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
        try(Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        // Listar usuarios
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("contraseña")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    

    }

