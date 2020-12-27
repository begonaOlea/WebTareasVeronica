package com.tareas.web;


import com.tareas.exception.UsuarioException;
import com.tareas.model.Gestion;
import com.tareas.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AltaUsuarioServlet", urlPatterns = {"/alta-nuevo-usuario"})
public class AltaUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        String paramPwd = request.getParameter("pwd");
        String paramNombre = request.getParameter("nombre");
        
        String msgErrorPwd = null;
        String msgErrorNombre = null;
        String msgErrorAlta = null;

        boolean valido = true;

      
        if (paramPwd == null || paramPwd.trim().length() == 0) {
            msgErrorPwd = "Debe indicar una contraseña";
            valido = false;
        }

        if (paramNombre == null || paramNombre.trim().length() == 0) {
            msgErrorNombre = "Debe indicar nombre ";
            valido = false;
        }
   
        
        if (valido) {
            Usuario usuario = new Usuario(paramNombre, paramPwd);
            try {
                Gestion.addUsuario(usuario);
                
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
            } catch (UsuarioException e) {
                msgErrorAlta = e.getMessage();
                valido = false;               
            }
        }//fin datos validos

        String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "indexRegistrados.jsp";
        } else {
            jspAMostrar = "form-alta-usuario.jsp";
            request.setAttribute("msgErrorPwd", msgErrorPwd);
            request.setAttribute("msgErrorNombre", msgErrorNombre);
            request.setAttribute("msgErrorAlta", msgErrorAlta);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(jspAMostrar);
        rd.forward(request, response);

    }

   
}
