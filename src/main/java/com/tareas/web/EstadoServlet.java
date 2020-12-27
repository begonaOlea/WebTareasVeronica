
package com.tareas.web;

import com.tareas.exception.TareaException;
import com.tareas.exception.UsuarioException;
import com.tareas.model.Gestion;
import com.tareas.model.Tarea;
import com.tareas.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EstadoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String mensaje = null;
        HttpSession sesion = request.getSession();

        String nombreUsuario = (String) sesion.getAttribute("nombre");
        String clave = (String) sesion.getAttribute("psw");

        Usuario u = new Usuario(nombreUsuario, clave); 
        
        String paramDescripcion = request.getParameter("descripcion");
        String paramPrioridad = request.getParameter("prioridad");
        String paramEstado = request.getParameter("estado");
        String nuevoEstado = request.getParameter("nuevoEstado");
        
        Tarea t = new Tarea(paramDescripcion,paramEstado,paramPrioridad,u);
        
        
        try {
            
            Gestion.cambiarEstado(u, t, nuevoEstado);
        } catch (TareaException ex) {
                mensaje = "Debe indicar descripcion, estado y prioridad de la tarea";
        } catch (UsuarioException ex) {
                mensaje = "Debe indicar un usuario válido";
        }
        
        
        RequestDispatcher rd = request.getRequestDispatcher("tareasUsuario.jsp");
        
        request.setAttribute("mensaje", mensaje);        
        rd.forward(request, response);
    }

    
}
