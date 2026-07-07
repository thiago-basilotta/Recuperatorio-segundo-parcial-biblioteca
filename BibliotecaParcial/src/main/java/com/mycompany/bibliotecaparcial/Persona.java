/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaparcial;

import java.io.Serializable;



public class Persona implements Serializable {
   protected String nombre;
   protected String dni;

    public Persona(String nombre, String dni) {
        if (dni == null || dni.isEmpty()){
            System.out.println("DNI invalido");
        }
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", dni=" + dni + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
