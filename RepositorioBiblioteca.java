/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblotecaparcial;

/**
 *
 * @author thiag
 */
import java.io.Serializable;

/**
 *
 * @author thiag
 */
public class Libro extends Material implements Serializable {
    private String titulo;
    private String autor;
    private int anioLanzamiento;

    public Libro(String titulo, String autor, int anioLanzamiento, boolean disponible, int idMaterial) {
        super(disponible, idMaterial);
        if(titulo == null || titulo.isEmpty()){
            System.out.println("Titulo vacío");
        } else {
            this.titulo = titulo; 
        }
        if(autor == null || autor.isEmpty()){
            System.out.println("Autor vacio, error");
        } else{
            
             this.autor = autor;
        }
        this.anioLanzamiento = anioLanzamiento;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", anioLanzamiento=" + anioLanzamiento + ", disponible=" + disponible + ", idMaterial=" + idMaterial + '}';
    }

   
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    @Override
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    
    
    
    
    
}