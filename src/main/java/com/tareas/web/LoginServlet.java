
package com.tareas.web;

import com.tareas.exception.LoginException;
import com.tareas.servicios.ServicioLogin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //LEER PARAMETROS
        String nombreUsuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        
        //VALIDAR
        String msgErrorUsuario = null;
        String msgErrorPassword = null;
        String msgErrorLogin = null;
        
        
          boolean ok = true;

        if (nombreUsuario == null || nombreUsuario.trim().length() == 0) {
            msgErrorUsuario = "Debe introducir el nombre del usuario";
            ok = false;
        }
     
        if (password == null || password.trim().length() == 0) {
            msgErrorPassword = "Debe introducir la contraseña";
            ok = false;
        }
        if(ok){
            try {
                HttpSession sesion = req.getSession();
                ServicioLogin servicio = new ServicioLogin();
                servicio.login(nombreUsuario, password, sesion);
            } catch (LoginException ex) {
                msgErrorLogin = ex.getMessage();
                ok = false;
            }
        }
        
        String jspAMostrar = "";
        if (ok) {
            jspAMostrar = "inicio.jsp";
        } else {
            jspAMostrar = "login.jsp";
            req.setAttribute("msgErrorUsuario", msgErrorUsuario);
            req.setAttribute("msgErrorPassword", msgErrorPassword);
            req.setAttribute("msgErrorLogin", msgErrorLogin);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);
    }//fin post
   
}


