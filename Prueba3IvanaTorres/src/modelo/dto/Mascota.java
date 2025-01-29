/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

import java.util.Date;

/**
 *
 * @author PAAPCA02LC0828
 */
public class Mascota {
    private int edad;
    private String Chip,nombreMascota, fechaNacimiento;
    private Dueno dueno;

    public Mascota() {
    }

    public Mascota(int edad, String Chip, String nombreMascota, String fechaNacimiento, Dueno dueno) {
        setEdad(edad);
        setChip(Chip);
        setNombreMascota(nombreMascota);
        setFechaNacimiento(fechaNacimiento);
        setDueno(dueno);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getChip() {
        return Chip;
    }

    public void setChip(String Chip) {
        this.Chip = Chip;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    @Override
    public String toString() {
        return "Mascota{" + "edad=" + edad + ", Chip=" + Chip + ", nombreMascota=" + nombreMascota + ", fechaNacimiento=" + fechaNacimiento + ", dueno=" + dueno + '}';
    }

  
    
    
}
