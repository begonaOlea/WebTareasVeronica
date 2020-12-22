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
        Map<String, Tarea> tareas = new HashMap<String, Tarea>();
        
        List<Tarea> listaTareas = new ArrayList<Tarea>();
        
        tareas.put("laura12", new Tarea("trabajar", "inprogress","alta","laura12"));
        tareas.put("roberto2", new Tarea("dibujar", "todo","baja","roberto2"));
        tareas.put("er", new Tarea("fdd", "done","media","roberto2"));
        tareas.put("alberto34", new Tarea("bail", "inprogress","baja","alberto34"));
        
        for(Tarea t: tareas.values()){
            System.out.println(t.toString());
        }
        
        for(String k : tareas.keySet()){
            System.out.println(k);
        }
        //System.out.println(".............");
    }
    
}
