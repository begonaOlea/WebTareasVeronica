package com.tareas.model;

import com.tareas.model.Gestion;
import com.tareas.exception.TareaException;
import com.tareas.exception.UsuarioException;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PruebaGestion {

    public static void main(String[] args) throws TareaException {

        Map<String, ArrayList<Tarea>> mapInicial = Gestion.getTareasPorUsuario();

        System.out.println(".......EL MAPA INICIAL......");
        //Ver keys de mapInicial
        System.out.println(".......CLAVES......");
        for (String key : mapInicial.keySet()) {
            System.out.println(key);
        }
        System.out.println(".....VALORES.......");

        //Ver todos los arrays de tareas
        for (ArrayList<Tarea> t : mapInicial.values()) {
            System.out.println(t.toString());
        }
        System.out.println(".................");
        System.out.println(".................");

        System.out.println(".....AÑADIMOS UN USUARIO.......");

        try {
            Gestion.addUsuario(new Usuario("paco78", "78"));
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }
        //Ver keys de mapInicial
        System.out.println(".......CLAVES......");
        for (String key : mapInicial.keySet()) {
            System.out.println(key);
        }
        System.out.println(".....VALORES.......");

        //Ver todos los arrays de tareas
        for (ArrayList<Tarea> t : mapInicial.values()) {
            System.out.println(t.toString());
        }
        System.out.println(".................");
        System.out.println(".................");

        System.out.println(".....AÑADIMOS UNA TAREA AL USUARIO paco78.......");

        try {
            Gestion.addTarea(new Usuario("paco78", "78"), new Tarea("comer", "TODO", "alta", new Usuario("paco78", "78")));
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }
        //Ver keys de mapInicial
        System.out.println(".......CLAVES......");
        for (String key : mapInicial.keySet()) {
            System.out.println(key);
        }
        System.out.println(".....VALORES.......");

        //Ver todos los arrays de tareas
        for (ArrayList<Tarea> t : mapInicial.values()) {
            System.out.println(t.toString());
        }
        System.out.println(".................");
        System.out.println(".................");

        System.out.println(".....ELIMINAMOS UNA TAREA DEL USUARIO Vero21.......");

        try {
            Gestion.eliminarTarea(new Usuario("Vero21", "21"), new Tarea("comer", "TODO", "alta", new Usuario("Vero21", "21")));
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }
        //Ver keys de mapInicial
        System.out.println(".......CLAVES......");
        for (String key : mapInicial.keySet()) {
            System.out.println(key);
        }
        System.out.println(".....VALORES.......");

        //Ver todos los arrays de tareas
        for (ArrayList<Tarea> t : mapInicial.values()) {
            System.out.println(t.toString());
        }
        System.out.println(".................");
        System.out.println(".................");

        System.out.println(".....CAMBIAMOS EL ESTADO DE LA TAREA COMER DEL USUARIO Vero21.......");

        try {
            Gestion.cambiarEstado(new Usuario("Vero21", "21"), new Tarea("dormir", "DONE", "media", new Usuario("Vero21", "21")), "TODO");
        } catch (TareaException ex) {
            System.out.println(ex.getMessage());
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }

        //Ver keys de mapInicial
        System.out.println(".......CLAVES......");
        for (String key : mapInicial.keySet()) {
            System.out.println(key);
        }
        System.out.println(".....VALORES.......");

        //Ver todos los arrays de tareas
        for (ArrayList<Tarea> t : mapInicial.values()) {
            System.out.println(t.toString());
        }
        System.out.println(".................");
        System.out.println(".................");

        System.out.println(".....VEMOS LAS TAREAS DEL USUARIO Juli3.......");

        try {
            Collection<Tarea> tareasJuli3 = Gestion.getTareasPorUsuario(new Usuario("Juli3", "3"));
            for (Tarea t : tareasJuli3) {
                System.out.println(t.toString());
            }
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(".....ELIMINAMOS EL USUARIO Carlos33....");

        try {
            Gestion.eliminarUsuario(new Usuario("Carlos33", "33"));
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }

        //Ver keys de mapInicial
        System.out.println(".......CLAVES......");
        for (String key : mapInicial.keySet()) {
            System.out.println(key);
        }
        System.out.println(".....VALORES.......");

        //Ver todos los arrays de tareas
        for (ArrayList<Tarea> t : mapInicial.values()) {
            System.out.println(t.toString());
        }
        System.out.println(".................");
        System.out.println(".................");

        System.out.println(".....VEMOS TAREAS TODO DE USUARIO Vero21....");

        Collection<Tarea> tareasTODOvero;
        try {
            tareasTODOvero = Gestion.getTareasPorUsuarioYEstado(new Usuario("Vero21", "21"), "TODO");
            for (Tarea t : tareasTODOvero) {
                System.out.println(t.toString());
            }
        } catch (UsuarioException ex) {
            System.out.println(ex.getMessage());
        }
        

    }
}