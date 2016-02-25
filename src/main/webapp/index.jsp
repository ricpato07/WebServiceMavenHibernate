<%-- 
    Document   : index
    Created on : 22-feb-2016, 18:03:53
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebService Hibernate</title>
    </head>
    <body>
        <h1>WebService Hibernate</h1>
        <form action="resources/bancos" method="POST">
            <label for="sbanco">Banco:</label>
            <input name="sbanco" />
            <br/>
            <input type="submit" value="Agregar" />
        </form>
        <br/><br/>
        <a href="resources/bancos">Listar todos</a>
        <br/><br/>
        <a href="resources/bancos/2">Listar uno</a>
         <br/><br/>
        <a href="delete">borrar</a>
          <br/><br/>
        <a href="update">update</a>
    </body>

</html>
