package com.tareas.servicios;

import com.tareas.exception.TareaException;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GestionarTarea {

    private static Map<String, ArrayList<Tarea>> tareasPorUsuario;
    private static ArrayList<Tarea> listaTareas;

    private static ArrayList<Tarea> listaTareasVero;
    private static ArrayList<Tarea> listaTareasAndoni;
    private static ArrayList<Tarea> listaTareasJuli;
    private static ArrayList<Tarea> listaTareasCarlos;

    static {
        tareasPorUsuario = new HashMap<String, ArrayList<Tarea>>();
        listaTareas = new ArrayList<Tarea>();

        listaTareasVero = new ArrayList<Tarea>();
        listaTareasAndoni = new ArrayList<Tarea>();
        listaTareasJuli = new ArrayList<Tarea>();
        listaTareasCarlos = new ArrayList<Tarea>();

        listaTareasVero.add(new Tarea("comer", "TODO", "alta", "Vero21"));
        listaTareasVero.add(new Tarea("dormir", "DONE", "media", "Vero21"));
        listaTareasAndoni.add(new Tarea("ordenar", "INPROGRESS", "media", "Andoni02"));
        listaTareasJuli.add(new Tarea("trabajar", "TODO", "baja", "Juli3"));
        listaTareasJuli.add(new Tarea("ver pei", "TODO", "alta", "Juli3"));

        tareasPorUsuario.put("Vero21", listaTareasVero);
        tareasPorUsuario.put("Andoni02", listaTareasAndoni);
        tareasPorUsuario.put("Juli3", listaTareasJuli);
        tareasPorUsuario.put("Carlos33", listaTareasCarlos);
    }

    private GestionarTarea() {
    }

    public static void addTarea(String usuario, Tarea tarea) throws TareaException {

        //falta meter el equals... para que no añada una tarea que ya existe
        if (tareasPorUsuario.containsKey(usuario)) {

            tareasPorUsuario.get(usuario).add(tarea);

            for (Tarea t : tareasPorUsuario.get(usuario)) {
                System.out.println(t.toString());
            }
        } else {
            throw new TareaException("El usuario introducido no existe");
        }

    }

    public static void eliminarTarea(String usuario, Tarea tarea) throws TareaException {

        if (tareasPorUsuario.containsKey(usuario)) {

            tareasPorUsuario.get(usuario).remove(tarea);

            for (Tarea t : tareasPorUsuario.get(usuario)) {
                System.out.println(t.toString());
            }
        } else {
            throw new TareaException("El usuario introducido no existe");
        }
    }

    public static void cambiarEstado(String usuario, Tarea tarea, String estado) throws TareaException {

        if (tareasPorUsuario.containsKey(usuario)) {
            for (Tarea t : tareasPorUsuario.get(usuario)) {
                if (t.equals(tarea)) {
                    t.setEstado(estado);
                    for (Tarea tar : tareasPorUsuario.get(usuario)) {
                        System.out.println(tar.toString());
                    }
                } else {
                    throw new TareaException("La tarea introducida no existe");
                }
            }
        } else {
            throw new TareaException("El usuario introducido no existe");
        }
    }
    
    public static Collection<Tarea> getTareasPorUsuario(String usuario)throws TareaException{
        
        Collection<Tarea> tareas;
        if(tareasPorUsuario.containsKey(usuario)){
             tareas = tareasPorUsuario.get(usuario);
             for(Tarea t : tareas){
                 System.out.println(t.toString());
             }
         }else{
             throw new TareaException("El usuario introducido no existe");
         }
         return tareas;
    }

    public static Map<String, ArrayList<Tarea>> getTareasPorUsuario() {
        return tareasPorUsuario;
    }

    public static void setTareasPorUsuario(Map<String, ArrayList<Tarea>> tareasPorUsuario) {
        GestionarTarea.tareasPorUsuario = tareasPorUsuario;
    }
    
    
        
}
