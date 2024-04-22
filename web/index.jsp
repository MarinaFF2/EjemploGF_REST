<%-- 
    Document   : index
    Created on : 05-ene-2020, 19:16:24
    Author     : faranzabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println("Servicios WEB disponibles");
        %>
        <br>
        <a href="http://localhost:8080/EjemploGF/app/Multiplicacion?n1=9&n2=10">http://localhost:8080/EjemploGF/app/Multiplicacion?n1=9&n2=10</a>
        <br>
        <a href="http://localhost:8080/EjemploGF/app/ServicioDatos">http://localhost:8080/EjemploGF/app/ServicioDatos</a>
        <br>
        <a href="http://localhost:8080/EjemploGF/app/ServicioDatos/2">http://localhost:8080/EjemploGF/app/ServicioDatos/2</a>
        <br>
        <a href="http://localhost:8080/EjemploGF/app/ServicioDatos/otro?id=3">http://localhost:8080/EjemploGF/app/ServicioDatos/otro?id=3</a> 
        <br>
        
        
    </body>
</html>
