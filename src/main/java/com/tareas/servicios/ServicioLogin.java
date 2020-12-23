package com.tareas.servicios;

import com.tareas.exception.LoginException;
import com.tareas.model.Usuario;
import java.util.Collection;
import javax.servlet.http.HttpSession;

public class ServicioLogin {

    public void login(String nombreUsuario, String password, HttpSession sesion) throws LoginException {
        
        Collection<Usuario> usuarios = Gestion.getUsuarios();
        Usuario usrEncontrado = null;
        
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombreUsuario)) {
                usrEncontrado = u;
                break;
            }
        }
   
        if (usrEncontrado == null) {
            throw new LoginException("El usuario no existe. Debe registrarse.");
        }else{
            if(usrEncontrado.getPassword().equals(password)){
                //añadir a sesion
                sesion.setAttribute("usuario", usrEncontrado);
            }else{
                throw new LoginException("Contraseña no válida");
            }
        }
        
    }//fin login

    public void logout(HttpSession sesion) {
        sesion.invalidate();
    }//fin logout

}
