/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author user
 */
public class PruebasTarea {
    public static void main(String[] args) {
        Map<String, ArrayList<Tarea>> tareasPorUsuario = new HashMap<String, ArrayList<Tarea>>();
        
        ArrayList<Tarea> listaTareas = new ArrayList< Tarea>();
        
        listaTareas.add(new Tarea("comer", "TODO","alta","Vero21"));
        listaTareas.add(new Tarea("dormir", "DONE","media","Vero21"));
        listaTareas.add(new Tarea("ordenar", "INPROGRESS","media","Andoni02"));
        listaTareas.add(new Tarea("trabajar", "TODO","baja","Juli3"));
        listaTareas.add(new Tarea("ver pei", "TODO","alta","Juli3"));
        
        for(Tarea tarea: listaTareas){
            tareasPorUsuario.put(tarea[3], A);
        }
        for(Tarea t: tareasPorUsuario.keySet()){
            System.out.println(t.toString());
        }
        
        for(String k : tareasPorUsuario.keySet()){
            System.out.println(k);
        }
        //System.out.println(".............");
    }
    
}
