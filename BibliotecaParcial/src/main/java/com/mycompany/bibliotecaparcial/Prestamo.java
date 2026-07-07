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
public class Prestamo implements Serializable {
    private Socio socio;
    private Libro libro;
    private boolean devuelto;

    public Prestamo(Socio socio, Libro libro) {
        this.socio = socio;
        this.libro = libro;
        this.devuelto = false;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "socio=" + socio + ", libro=" + libro + ", devuelto=" + devuelto + '}';
    }

    public Socio getSocio() {
        return socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
    
    
    public void marcarDevuelto(){
        if(devuelto != true){
            this.devuelto = true; 
            libro.setDisponible(true);  
            System.out.println("El libro fue devuelto");
        } else 
            
            System.out.println("Este prestamo ya estaba devuelto");
    }



}
