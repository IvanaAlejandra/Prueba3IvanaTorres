/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

/**
 *
 * @author PAAPCA02LC0828
 */
public class Usuario {
    private int id;
    private String usuario,contrasena;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String contrasena) {
        setId(id);
        setUsuario(usuario);
        setContrasena(contrasena);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }

    
  
    
    
}
