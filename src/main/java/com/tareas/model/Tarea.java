/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.model;

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
    
    
}
