
package com.tareas.web;

import com.tareas.exception.LoginException;
import com.tareas.servicios.ServicioLogin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String paramNombre = req.getParameter("nombre");
        String paramPwd = req.getParameter("pwd");
        
        String msgErrorNombre = null;
        String msgErrorPwd = null;
        String msgErrorLogin = null;
        
        
          boolean valido = true;

        if (paramNombre == null || paramNombre.trim().length() == 0) {
            msgErrorNombre = "Debe indicar el nombre del usuario";
            valido = false;
        }
      
        if (paramPwd == null || paramPwd.trim().length() == 0) {
            msgErrorPwd = "Debe indicar una clave";
            valido = false;
        }
        if(valido){
            try {
                HttpSession sesion = req.getSession();
                ServicioLogin servicio = new ServicioLogin();
                servicio.login(paramNombre, paramPwd, sesion);
            } catch (LoginException ex) {
                msgErrorLogin = ex.getMessage();
                valido = false;
            }
        }
       
     String jspAMostrar = "";
        if (valido) {
            jspAMostrar = "indexLogeados.jsp";
        } else {
            jspAMostrar = "login.jsp";
            req.setAttribute("msgErrorEmail", msgErrorNombre);
            req.setAttribute("msgErrorPwd", msgErrorPwd);
            req.setAttribute("msgErrorLogin", msgErrorLogin);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher(jspAMostrar);
        rd.forward(req, resp);
    }//fin post
   
}

