/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.model;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Tarea {
    
    //ATRIBUTOS
    
    private String descripcion;
    private String estado;  //TODO, INPROGRESS, DONE
    private String prioridad;  //BAJA, MEDIA, ALTA
    private String usuario;
    
    //CONSTRUCTOR

    public Tarea(String descripcion, String estado, String prioridad, String usuario) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.usuario = usuario;
    }

    //MÉTODOS

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarea{" + "descripcion=" + descripcion + ", estado=" + estado + ", prioridad=" + prioridad + ", usuario=" + usuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.descripcion);
        return hash;
    }
    
    //Diremos que dos tareas son IGUALES si tienen la misma DESCRIPCIÓN
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }
    
    
}
