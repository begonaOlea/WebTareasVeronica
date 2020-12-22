
package com.tareas.servicios;

import com.tareas.exception.UsuarioException;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.Collection;
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
    
    public synchronized static void addUsuario(Usuario usuario) throws UsuarioException {
        boolean okToAdd = usuarios.add(usuario);
        if (!okToAdd) {
            throw new UsuarioException("El usuario no pudo ser añadido porque ya existe.");
        }
        for(Usuario u : usuarios){
            System.out.println(u.toString());
        }
    }
    
    public synchronized static void eliminarUsuario(Usuario usuario) throws UsuarioException {
        
        //si se elimina el usuario, también se eliminarán sus tareas
        
        if (GestionarTarea.getTareasPorUsuario().containsKey(usuario.getNombre())) {
             for(Tarea t: GestionarTarea.getTareasPorUsuario().get(usuario.getNombre())){
                 
             }
        }  
     }
}
