
package com.tareas.model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable{
   
    //ATRIBUTOS
    
    private String nombre;
    private String password;
   
    
    //CONSTRUCTOR

    public Usuario(String nombre, String password) {
        this.password = password;
        this.nombre = nombre;
    }
    
    //MÉTODOS

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "password=" + password + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    
    //Diremos que dos usuarios son IGUALES cuando tienen el mismo NOMBRE
    
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
   
    
}
