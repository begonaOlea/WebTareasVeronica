<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container p-3 my-3 bg-info text-white">
            <h1>Acceso a tus tareas</h1>
        </div>
        <div class="container">

            <%@include file="WEB-INF/vista/navegacion.jspf" %>

            <div class="row">
                <div class="col">
                </div>
            </div>
            <form action="login" method="post" >
                <div class="form-group">
                    <label for="usuario">Usuario</label>
                    <input type="usuario" class="form-control" name="usuario"
                           id="usuario" placeholder="Verita34">
                     <div class="col">${ requestScope.msgErrorUsuario }</div>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password"
                           id="pwd" placeholder="******">
                     <div class="col">${ requestScope.msgErrorPassword }</div>
                </div>
                <div class="container">
                    <a href="alta-usuario.jsp" class="btn btn-primary">Registrarse </a>                
                    <button type="submit" class="btn btn-primary">Log in</button>
                </div>
            </form>

                 
        </div>
    </body>
</html>