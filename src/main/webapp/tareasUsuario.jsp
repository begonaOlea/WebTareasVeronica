<%@page import="com.tareas.model.Usuario"%>
<%@page import="com.tareas.model.Tarea"%>
<%@page import="java.util.Collection"%>
<%@page import="com.tareas.model.Gestion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis tareas</title>
        <%@include file="WEB-INF/vista/estilos.jspf" %>
    </head>
    <style>
        body  {
            background-image: url("imgs/imgInicio.jpg");
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            height: 500px;
            position: relative;
        }
        .center {
            text-align: center;
            color: white;
            margin: 250px 250px 250px 250px;


        }
        h1{
            color: black;
        }
        div.transbox {
            text-align: center;
            margin-top: 30px;
            margin-left: 250px;
            margin-right: 250px;
            background-color: #ffffff;
            opacity: 0.8;
            color:black;
            border-radius: 25px;
            padding-bottom: 20px;
            padding-left: 20px;
            padding-right: 20px;
            padding-top: 20px;
        }
        .abs-center {
            display: flex;
            align-items: center;
            justify-content: center;



        }


    </style>
    <body>
       

        <% HttpSession sesion = request.getSession();

            String nombreUsuario = (String) sesion.getAttribute("nombre");
            String clave = (String) sesion.getAttribute("psw");

            Usuario u = new Usuario(nombreUsuario, clave);

            Collection<Tarea> tareasTODO = Gestion.getTareasPorUsuarioYEstado(u, "TODO");
            Collection<Tarea> tareasINPROGRESS = Gestion.getTareasPorUsuarioYEstado(u, "INPROGRESS");
            Collection<Tarea> tareasDONE = Gestion.getTareasPorUsuarioYEstado(u, "DONE");
        %>

        <div class="transbox">


            <div class="row">
                <div class="col">
                    <%@include file="WEB-INF/vista/navegacionMisTareas.jspf" %>

                    <h1>Mis tareas</h1>
                </div>
            </div>

            <table class="table table-striped" id="tablaTODO">
                <thead>
                    <tr>
                        <th scope="col">TAREAS POR HACER</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>

                    <% for (Tarea t : tareasTODO) {%>
                    <tr>
                        <td><%= "Descripción: " + t.getDescripcion()%></td>
                        <td><%= "Prioridad: " + t.getPrioridad()%></td>
                        <td>
                            <a href="eliminar?descripcion=<%= t.getDescripcion()%>&prioridad=<%= t.getPrioridad()%>&estado=TODO" class="btn btn-primary" >Eliminar</a>
                        </td>
                        <td>
                            <a href="estado?descripcion=<%= t.getDescripcion()%>&prioridad=<%= t.getPrioridad()%>&estado=TODO&nuevoEstado=INPROGRESS" class="btn btn-primary" >En progreso</a>
                        </td>
                    </tr>   
                    <% }%>
                </tbody>
            </table>


            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">TAREAS EN PROGRESO</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>

                    <% for (Tarea t : tareasINPROGRESS) {%>
                    <tr>
                        <td><%= "Descripción: " + t.getDescripcion()%></td>
                        <td><%= "Prioridad: " + t.getPrioridad()%></td>
                        <td>
                            <a href="eliminar?descripcion=<%= t.getDescripcion()%>&prioridad=<%= t.getPrioridad()%>&estado=INPROGRESS" class="btn btn-primary" >Eliminar</a>

                        </td>
                        <td>
                            <a href="estado?descripcion=<%= t.getDescripcion()%>&prioridad=<%= t.getPrioridad()%>&estado=INPROGRESS&nuevoEstado=DONE" class="btn btn-primary" >Acabada</a>
                        </td>
                    </tr>   
                    <% }%>
                </tbody>
            </table>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">TAREAS TERMINADAS</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>

                    <% for (Tarea t : tareasDONE) {%>
                    <tr>
                        <td><%= "Descripción: " + t.getDescripcion()%></td>
                        <td><%= "Prioridad: " + t.getPrioridad()%></td>
                        <td>
                            <a href="eliminar?descripcion=<%= t.getDescripcion()%>&prioridad=<%= t.getPrioridad()%>&estado=DONE" class="btn btn-primary" >Eliminar</a>

                        </td>
                    </tr>   
                    <% }%>
                </tbody>
            </table>
        </div>

    </body>

</html>


