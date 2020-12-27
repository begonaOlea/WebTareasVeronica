package com.tareas.web;

import com.tareas.servicios.ServicioLogin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ususario
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
      ServicioLogin servicio = new ServicioLogin();
      servicio.logout(req.getSession());      
      RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
      rd.forward(req, resp);
    }
    
}
