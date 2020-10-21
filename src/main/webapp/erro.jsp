<%-- 
    Document   : erro
    Created on : 19/10/2020, 15:27:06
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro!</title>
    </head>
    <body>
        <h1>Erro!</h1>
        <br/>
        ${msgErro}
        <br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
