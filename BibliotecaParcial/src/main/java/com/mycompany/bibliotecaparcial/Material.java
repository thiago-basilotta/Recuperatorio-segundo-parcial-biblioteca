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
public class Material implements Serializable {
    protected boolean disponible;
    protected int idMaterial;

    public Material(boolean disponible, int idMaterial) {
        this.disponible = disponible;
        this.idMaterial = idMaterial;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Material{" + "disponible=" + disponible + ", idMaterial=" + idMaterial + '}';
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

 
}
