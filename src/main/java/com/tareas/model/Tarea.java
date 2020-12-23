
package com.tareas.model;

import java.util.Objects;

public class Tarea {
    
    //ATRIBUTOS
    
    private String descripcion;
    private String estado;  //TODO, INPROGRESS, DONE
    private String prioridad;  //BAJA, MEDIA, ALTA
    private Usuario usuario;
    
    //CONSTRUCTOR

    public Tarea(String descripcion, String estado, String prioridad, Usuario usuario) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarea{" + "descripcion=" + descripcion + ", estado=" + estado + ", prioridad=" + prioridad + ", usuario=" + usuario.toString() + '}';
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
