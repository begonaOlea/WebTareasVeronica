package com.tareas.servicios;

import com.tareas.exception.TareaException;
import com.tareas.exception.UsuarioException;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Gestion {

    private static Map<String, ArrayList<Tarea>> tareasPorUsuario;
    private static ArrayList<Tarea> listaTareas;
    private static Set<Usuario> usuarios;

    private static ArrayList<Tarea> listaTareasVero;
    private static ArrayList<Tarea> listaTareasAndoni;
    private static ArrayList<Tarea> listaTareasJuli;
    private static ArrayList<Tarea> listaTareasCarlos;
    
    static {
        tareasPorUsuario = new HashMap<String, ArrayList<Tarea>>();
        listaTareas = new ArrayList<Tarea>();
        usuarios = new HashSet<Usuario>();

        listaTareasVero = new ArrayList<Tarea>();
        listaTareasAndoni = new ArrayList<Tarea>();
        listaTareasJuli = new ArrayList<Tarea>();
        listaTareasCarlos = new ArrayList<Tarea>();
        
        Usuario usuario1 = new Usuario("Vero21","21");
        Usuario usuario2 = new Usuario("Andoni02","02");
        Usuario usuario3 = new Usuario("juli3","3");
        Usuario usuario4 = new Usuario("carlos33","33");
        
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);

        listaTareasVero.add(new Tarea("comer", "TODO", "alta", usuario1));
        listaTareasVero.add(new Tarea("dormir", "DONE", "media", usuario1));
        listaTareasAndoni.add(new Tarea("ordenar", "INPROGRESS", "media", usuario2));
        listaTareasJuli.add(new Tarea("trabajar", "TODO", "baja", usuario3));
        listaTareasJuli.add(new Tarea("ver pei", "TODO", "alta", usuario3));

        tareasPorUsuario.put("Vero21", listaTareasVero);
        tareasPorUsuario.put("Andoni02", listaTareasAndoni);
        tareasPorUsuario.put("Juli3", listaTareasJuli);
        tareasPorUsuario.put("Carlos33", listaTareasCarlos);
    }
    
     private Gestion() {
    }
    
    //CON ESTA CLASE SE GESTIONAN TAREAS Y USUARIOS
     
    public static Map<String, ArrayList<Tarea>> getTareasPorUsuario() {
        return tareasPorUsuario;
    }
     
    public static void addUsuario(Usuario usuario) throws UsuarioException{
        if(tareasPorUsuario.containsKey(usuario.getNombre())){
            throw new UsuarioException("El usuario introducido ya existe");
        }else{
            tareasPorUsuario.put(usuario.getNombre(), listaTareas);
        }
    }
    
    public static void eliminarUsuario(Usuario usuario) throws UsuarioException{
        
        if (tareasPorUsuario.containsKey(usuario.getNombre())) {
            tareasPorUsuario.remove(usuario.getNombre());
        } else {
            throw new UsuarioException("El usuario introducido no existe");
        }
        
    }

    public static Set<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
    public static void addTarea(Usuario usuario, Tarea tarea) throws TareaException, UsuarioException{

        //falta meter el equals... para que no añada una tarea que ya existe
        
        if (tareasPorUsuario.containsKey(usuario.getNombre())) {
            tareasPorUsuario.get(usuario.getNombre()).add(tarea);
        } else {
            throw new UsuarioException("El usuario introducido no existe");
        }

    }
    
    public static void eliminarTarea(Usuario usuario, Tarea tarea) throws TareaException, UsuarioException {

        if (tareasPorUsuario.containsKey(usuario.getNombre())) {
            if(tareasPorUsuario.get(usuario.getNombre()).contains(tarea)){
                tareasPorUsuario.get(usuario.getNombre()).remove(tarea);
            }else{
                throw new TareaException("La tarea introducida no existe");
            }
        } else {
            throw new UsuarioException("El usuario introducido no existe");
        }
    }
    
    public static void cambiarEstado(Usuario usuario, Tarea tarea, String estado) throws TareaException, UsuarioException{

        if (tareasPorUsuario.containsKey(usuario.getNombre())) {
            for (Tarea t : tareasPorUsuario.get(usuario.getNombre())) {
                if (t.equals(tarea)) {
                    t.setEstado(estado);
                } else {
                    throw new TareaException("La tarea introducida no existe");
                }
            }
        } else {
            throw new UsuarioException("El usuario introducido no existe");
        }
    }
    
    public static Collection<Tarea> getTareasPorUsuario(Usuario usuario)throws UsuarioException{
        
        Collection<Tarea> tareas;
        if(tareasPorUsuario.containsKey(usuario.getNombre())){
             tareas = tareasPorUsuario.get(usuario.getNombre());
             
         }else{
             throw new UsuarioException("El usuario introducido no existe");
         }
         return tareas;
    }
}
