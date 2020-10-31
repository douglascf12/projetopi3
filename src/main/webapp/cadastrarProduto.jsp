<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <div class="container">
        <h1>Cadastro de Produto</h1>
        <form action="cadastrarProduto" method="POST">
            <p>preco</p>
            <input name="preco" class="form-control" required="true"/><br/>
            <p>descricao</p>
            <input name="descricao" class="form-control" required="true"/><br/>
            <p>qtd_estoque</p>
            <input name="qtd_estoque" class="form-control" required="true"/><br/>
            <p>nome_produto</p>
            <input name="nome_produto" class="form-control" required="true"/><br/>
            <p>categoria</p>
            <select name="categoria" class="form-control" required="true"/><br/>
            <option value="Cama">Cama</option>
            <option value="Mesa">Mesa</option>
            <option value="Banho">Banho</option>
            </select>

            <br/>
            <button type="submit" class="btn btn-primary">Enviar</button>

        </form>
    </div>