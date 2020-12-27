
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
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
                    <a class="nav-link" href="tareasUsuario.jsp">Volver a mis tareas</a>
                    <h1>Formulario para registrar la tarea</h1>

                </div>
            </div>
            <div class="container">
                <div class="abs-center">

                    <form action="AltaNuevaTarea" method="post" >
                        <div class="form-group">
                            <label for="descripcion">Descripción de la tarea</label>
                            <input type="descripcion" class="form-control" name="descripcion"
                                   id="descripcion" placeholder="Estudiar Java">
                            <div class="col">${ requestScope.msgErrorDescrip }</div>
                        </div>
                        <div class="form-group">
                            <label for="prioridad">Prioridad</label>
                            <input type="prioridad" class="form-control" name="prioridad"
                                   id="prioridad" placeholder="Alta">
                            <div class="col">${ requestScope.msgErrorPrioridad }</div>
                        </div>


                        <button type="submit" class="btn btn-primary">Aceptar</button>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>


