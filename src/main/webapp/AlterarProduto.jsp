<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <c:if test="${sessionScope.user.codFilial != produto.cod_filial}">
        <script>
            window.location.href = "acessoNaoAutorizado.jsp"
        </script>
    </c:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <div class="container">
        <h1>Alteração Cadastro de Produto: <br/></h1>
        <form action="AlterarProduto" method="POST">
            <p>Código</p>
            <input name="cod_produto" class="form-control" value="${produto.cod_produto}" readonly="true" /><br/>
            <p>Preco</p>
            <input name="preco" class="form-control"  value="${produto.preco}"/><br/>
            <p>Descricao</p>
            <input name="descricao" class="form-control"  value="${produto.descricao}"/><br/>
            <p>Qtd_estoque</p>
            <input name="qtd_estoque" class="form-control" value="${produto.qtd_estoque}" /><br/>
            <p>Nome Produto</p>
            <input name="nome_produto" class="form-control" value="${produto.nome_produto}" /><br/>
            <p>Categoria</p>
            <select name="categoria" class="form-control" value="${produto.categoria}"/><br/>
            <option value="Cama">Cama</option>
            <option value="Mesa">Mesa</option>
            <option value="Banho">Banho</option>
            </select>
            <br/>
            <br/>
            <button type="submit"class="btn btn-primary">Enviar</button>
        </form>
    </div>