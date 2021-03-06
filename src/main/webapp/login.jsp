<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
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
        .abs-center {
            display: flex;
            align-items: center;
            justify-content: center;



        }


    </style>
    <body>

        <div class="transbox">


            <div class="row">
                <div class="col">
                    <a class="nav-link" href="index.jsp">Volver a inicio</a>
                    <h1>Iniciar sesión</h1>

                </div>
            </div>
            
            <c:if test="${not empty requestScope.msgErrorLogin }" >
                <div class="alert alert-success" role="alert">
                    ${requestScope.msgErrorLogin}
                </div>
            </c:if>
                
            <div class="container">
                <div class="abs-center">
                    <form action="login" method="post" >
                        <div class="form-group">
                            <label for="nombre">Nombre de usuario</label>
                            <input type="nombre" class="form-control" name="nombre"
                                   id="nombre" placeholder="Ej:Vero21">
                            <div class="col">${ requestScope.msgErrorNombre }</div>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Contraseña</label>
                            <input type="password" class="form-control" name="pwd"
                                   id="pwd" placeholder="Contraseña">
                            <div class="col">${ requestScope.msgErrorPwd }</div>
                        </div>

                        <button type="submit" class="btn btn-primary">Log in</button>

                    </form>

                </div>
            </div>

        </div>

    </body>

</html>

