
package com.tareas.servicios;

import com.tareas.model.Usuario;
import java.util.HashSet;
import java.util.Set;

public class GestionUsuario {
    
    private static Set<Usuario> usuarios;
    
    static {
        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario("Vero21", "21"));
        usuarios.add(new Usuario("Andoni02", "02"));
        usuarios.add(new Usuario("Juli3", "3"));
        usuarios.add(new Usuario("Carlos33", "33"));
    
    }
    
    private GestionUsuario() {
    }
    
    
    
}
