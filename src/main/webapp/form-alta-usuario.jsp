
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
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
                    <h1>Formulario de registro</h1>

                </div>
            </div>

            <!-- mensaje error alta -->
            <c:if test="${not empty requestScope.msgErrorAlta }" >
                <div class="alert alert-success" role="alert">
                    ${requestScope.msgErrorAlta}
                </div>
            </c:if>


            <!--  formulario  -->


            <div class="container">
                <div class="abs-center">
                    <form action="alta-nuevo-usuario" method="post">
                        <div class="form-group">
                            <label>Nombre de usuario:</label>
                            <input type="nombre" class="form-control" id="nombre" 
                                   placeholder="Introduce un nombre" name="nombre">
                        </div>
                        <div class="col">${ requestScope.msgErrorNombre }</div>


                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" class="form-control" id="pwd" 
                                   placeholder="Introduce la contraseña" name="pwd">
                        </div>
                        <div class="col">${ requestScope.msgErrorPwd }</div>
                </div>
                
                <button type="submit" class="btn btn-primary">Aceptar</button>
              
                </form> 
            </div>
        </div>


    </body>
</html>

