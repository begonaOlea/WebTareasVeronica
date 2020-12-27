<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
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

        p{
            color: black;
        }
        div.transbox {
            text-align: center;
            margin: 250px 250px 250px 250px;
            background-color: #ffffff;
            opacity: 0.8;
            color:black;
            border-radius: 25px;
            padding-bottom: 20px;
            padding-left: 20px;
            padding-right: 20px;
            padding-top: 20px;
        }
    </style>

    <body>
        <div class="transbox">

            <h1>Bienvenido a TareasWebVero! </h1>

            <p>Aquí podrás tener una lista de tus tareas y hacer modificaciones sobre ellas.</p>
            <%@include file="WEB-INF/vista/navegacionInicio.jspf" %>
        </div>

    </body>
</html>



