<%-- 
    Document   : cadastrarProduto
    Created on : Sep 25, 2020, 9:26:59 PM
    Author     : tscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body class="container">
        <h1>Cadastro</h1>
        <form action="cadastrarProduto" method="POST">
            <p>preco</p>
            <input name="preco" class="form-control" required="true"/><br/>
            <p>descricao</p>
            <input name="descricao" class="form-control" required="true"/><br/>
            <p>qtd_estoque</p>
            <input name="qtd_estoque" class="form-control" required="true"/><br/>
            <p>nome_produto</p>
            <input name="nome_produto" class="form-control" required="true"/><br/>
            
            <button type="submit" class="btn btn-primary">Enviar</button>
            
        </form>
    </body>
</html>
