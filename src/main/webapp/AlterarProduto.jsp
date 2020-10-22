<%-- 
    Document   : alterarProduto
    Created on : Oct 2, 2020, 7:59:00 PM
    Author     : tscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body>
        <h1>Alteração Cadastro de Produto: ${produto.cod_produto}</h1>
        <form action="AlterarProduto" method="POST">
            <p>Preco</p>
            <input name="preco" value="${produto.preco}"/><br/>
            <p>Descricao</p>
            <input name="descricao" value="${produto.descricao}"/><br/>
            <p>Qtd_estoque</p>
            <input name="qtd_estoque" value="${produto.qtd_estoque}" /><br/>
            <p>Nome Produto</p>
            <input name="nome_produto" value="${produto.nome_produto}" /><br/>
            
            
            <button type="submit">Enviar</button>
            
        </form>
    </body>
</html>
