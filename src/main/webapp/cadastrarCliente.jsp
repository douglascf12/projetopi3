<%-- 
    Document   : cadastrarCliente
    Created on : 22/10/2020, 20:05:31
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body class="container">
        <h1>Cadastro</h1>
        <form action="CadastrarCliente" method="POST">
            <p>Nome</p>
            <input name="nome" class="form-control" required="true"/><br/>            
            <p>CPF</p>
            <input name="cpf_cliente" class="form-control" required="true"/><br/>
            <p>Telefone</p>
            <input name="telefone" class="form-control" required="true"/><br/>
            <p>data de Nascimento</p>
            <input name="data_nasc" class="form-control" required="true"/><br/>
            <p>Endereço</p>
            <input name="endereco" class="form-control" required="true"/><br/>
            <p>Sexo</p>
            <input name="sexo" class="form-control" required="true"/><br/>
            
            <button type="submit" class="btn btn-primary">Enviar</button>
            
        </form>
    </body>
</html>