/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaparcial;
import java.io.Serializable; 
/**
 *
 * @author thiag
 */
public class Socio extends Persona implements Serializable{
    private int cantidadPrestamosActivos;
    private int numeroSocio; 

    public Socio(int cantidadPrestamosActivos, int numeroSocio, String nombre, String dni) {
        super(nombre, dni);
        this.cantidadPrestamosActivos = cantidadPrestamosActivos;
        this.numeroSocio = numeroSocio;
    }

    @Override
    public String toString() {
        return "Socio{" + "cantidadPrestamosActivos=" + cantidadPrestamosActivos + ", numeroSocio=" + numeroSocio + ", nombre=" + nombre + ", DNI=" + dni + '}'; 
    }

    public int getCantidadPrestamosActivos() {
        return cantidadPrestamosActivos;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }


    public void setCantidadPrestamosActivos(int cantidadPrestamosActivos) {
        this.cantidadPrestamosActivos = cantidadPrestamosActivos;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    

    
}
