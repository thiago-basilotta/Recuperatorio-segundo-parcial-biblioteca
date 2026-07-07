/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaparcial;

import java.util.ArrayList;

/**
 *
 * @author thiag
 */
public class RepositorioBiblioteca <T>{
     private ArrayList<T> elementos = new ArrayList<>();
     
     
       public void agregar(T elemento){
        elementos.add(elemento); 
    }
    
    public ArrayList<T> listar() {
        return elementos; 
    }
    
    public T buscarPorIndice(int i){
        return elementos.get(i);
    }
    
}
