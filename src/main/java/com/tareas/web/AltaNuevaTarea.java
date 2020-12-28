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

public class AltaNuevaTarea extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        String paramDescripcion = request.getParameter("descripcion");
        String paramPrioridad = request.getParameter("prioridad");

        String msgErrorPrioridad = null;
        String msgErrorDescrip = null;
        String msgErrorAlta = null;

        boolean valido = true;

        if (paramDescripcion == null || paramDescripcion.trim().length() == 0) {
            msgErrorDescrip = "Debe indicar la descripción de la tarea";
            valido = false;
        }

        if (paramPrioridad == null || paramPrioridad.trim().length() == 0) {
            msgErrorPrioridad = "Debe indicar la prioridad de la tarea";
            valido = false;
        }

        if (valido) {

            HttpSession sesion = request.getSession();
            String nombreUsuario = (String) sesion.getAttribute("nombre");
            String clave = (String) sesion.getAttribute("psw");
            Usuario u = new Usuario(nombreUsuario, clave);

            Tarea tarea = new Tarea(paramDescripcion, "TODO", paramPrioridad, u);
            try {
                Gestion.addTarea(u, tarea);
            } catch (TareaException e) {
                msgErrorAlta = e.getMessage();
                valido = false;
            } catch (UsuarioException ex) {
                valido = false;
            }
        }

        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "tareasUsuario.jsp";
        } else {
            jspAMostrar = "nuevaTarea.jsp";
            request.setAttribute("msgErrorPrioridad", msgErrorPrioridad);
            request.setAttribute("msgErrorDescrip", msgErrorDescrip);
            request.setAttribute("msgErrorAlta", msgErrorAlta);
        }

        RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
        //rd.forward(request, response);
        response.sendRedirect(jspAMostrar);
    }

}
