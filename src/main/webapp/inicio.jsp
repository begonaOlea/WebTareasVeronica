
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container p-3 my-3 bg-info text-white">
            <h1>Bienvenido a TTW, tus tareas en la web!</h1>
            <p>Aquí podrás construir tu propia agenda de tareas online ;)</p>
        </div>
        
        <div class="col-2">
        <c:choose >
            <c:when test="${ not empty sessionScope.usuario}">
                <h5> Usuario:  ${ sessionScope.usuario.nombre}</h5>
                <a href="inicio.jsp">Log out</a>
            </c:when>
        </c:choose>

    </div>
        <div align="center"><img src="img/escribiendo.gif" alt="escribiendo"></div>
        
        <div class="d-flex flex-row justify-content-center alig-items-center">
            <%@include file="WEB-INF/vista/navegacion.jspf" %>
        </div>
        
    </body>
</html>
