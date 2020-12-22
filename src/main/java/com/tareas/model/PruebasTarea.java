
package com.tareas.model;

import com.tareas.exception.TareaException;
import com.tareas.servicios.GestionarTarea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PruebasTarea {

    public static void main(String[] args) {
        Map<String, ArrayList<Tarea>> tareasPorUsuario = new HashMap<String, ArrayList<Tarea>>();

        ArrayList<Tarea> listaTareasVero = new ArrayList< Tarea>();
        ArrayList<Tarea> listaTareasAndoni = new ArrayList< Tarea>();
        ArrayList<Tarea> listaTareasJuli = new ArrayList< Tarea>();
        ArrayList<Tarea> listaTareasCarlos = new ArrayList< Tarea>();

        listaTareasVero.add(new Tarea("comer", "TODO", "alta", "Vero21"));
        listaTareasVero.add(new Tarea("dormir", "DONE", "media", "Vero21"));
        listaTareasAndoni.add(new Tarea("ordenar", "INPROGRESS", "media", "Andoni02"));
        listaTareasJuli.add(new Tarea("trabajar", "TODO", "baja", "Juli3"));
        listaTareasJuli.add(new Tarea("ver pei", "TODO", "alta", "Juli3"));

        tareasPorUsuario.put("Vero21", listaTareasVero);
        tareasPorUsuario.put("Andoni02", listaTareasAndoni);
        tareasPorUsuario.put("Juli3", listaTareasJuli);
        tareasPorUsuario.put("Carlos33", listaTareasCarlos);
        
        //Ver que el equals funciona
        Tarea t1 = new Tarea("ver pei", "TODO", "alta", "Juli3");
        Tarea t2 = new Tarea("ver pei", "TODO", "alta", "Jufffli3");
        Tarea t3 = new Tarea("ver ffi", "TODO", "alta", "paco89");

        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));
        System.out.println(".................");

        //Ver keys
        for (String key : tareasPorUsuario.keySet()) {
            System.out.println(key);
        }
        System.out.println(".................");

        //Ver todos los arrays de tareas
        for (ArrayList<Tarea> t : tareasPorUsuario.values()) {
            System.out.println(t.toString());
        }
        System.out.println(".................");

        //Ver tareas de usuario vero21
        for (Tarea t : tareasPorUsuario.get("Vero21")) {
            System.out.println(t.toString());
        }
        System.out.println(".................");

        //uso del método addTarea (FUNCIONA)
        
        try {
            GestionarTarea.addTarea("Vero21", new Tarea("lalala", "DONE", "alta", "Vero21"));
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");

        try {
            GestionarTarea.addTarea("sdao21", new Tarea("jjj", "DONE","alta","Vero21"));
        } catch (TareaException ex) {
           System.out.println(ex.getMessage());
        
        }
        System.out.println(".................");
 
        try {
            GestionarTarea.addTarea("Vero21", new Tarea("lalala", "DONE", "alta", "Vero21"));
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");
        
        //uso del método eliminarTarea (FUNCIONA)
        try {
           GestionarTarea.eliminarTarea("Vero21", new Tarea("lalala", "DONE", "alta", "Vero21"));
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");
        
        try {
           GestionarTarea.eliminarTarea("f56", new Tarea("lalala", "DONE", "alta", "Vero21"));
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");
        
        //uso del método cambiarEstado (FUNCIONA)
        
        try {
           GestionarTarea.cambiarEstado("Andoni02", new Tarea("ordenar", "INPROGRESS", "media", "Andoni02"), "TODO");
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");
        
        try {
           GestionarTarea.cambiarEstado("Andoni02", new Tarea("limpiar", "INPROGRESS", "media", "Andoni02"), "TODO");
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");
        
        try {
           GestionarTarea.cambiarEstado("Anfffdoni02", new Tarea("ordenar", "INPROGRESS", "media", "Andoni02"), "TODO");
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");
        
        //uso del método getTareasPorUsuario (FUNCIONA)

        try {
            GestionarTarea.getTareasPorUsuario("Juli3");
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(".................");
        try {
            GestionarTarea.getTareasPorUsuario("Jsssuli3");
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
