
package com.tareas.model;

import com.tareas.exception.UsuarioException;
import com.tareas.servicios.GestionUsuario;
import java.util.Set;

public class PruebasUsuario {
    
    public static void main(String[] args) {
        
        //Vemos que se añade un usuario correctamente (FUNCIONA)
        
        try {
            GestionUsuario.addUsuario(new Usuario("neko11", "11"));
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("....................");
        try {
            GestionUsuario.addUsuario(new Usuario("neko11", "11"));
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("....................");
    }
    
    
    
}
