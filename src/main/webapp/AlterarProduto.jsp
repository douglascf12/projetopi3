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
    <body>
    <center>
        <div class="card w-75">
            <h5 class="card-header">Alteração do Produto: ${produto.cod_produto}</h5>
            <div class="card-body">
                <form action="AlterarProduto" method="POST">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Código</label>
                        <div class="col-sm-10">
                            <input name="cod_produto" class="form-control" value="${produto.cod_produto}" readonly="true" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Nome</label>
                        <div class="col-sm-10">
                            <input name="nome_produto" class="form-control" value="${produto.nome_produto}" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Descrição</label>
                        <div class="col-sm-10">
                            <input name="descricao" class="form-control"  value="${produto.descricao}"/><br/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Preço</label>
                        <div class="col-sm-10">
                            <input name="preco" class="form-control"  value="${produto.preco}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Qtd. Estoque</label>
                        <div class="col-sm-10">
                            <input name="qtd_estoque" class="form-control" value="${produto.qtd_estoque}" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Qtd. Estoque</label>
                        <div class="col-sm-10">
                            <select name="categoria" class="form-control" value="${produto.categoria}"/><br/>
                            <option value="Cama">Cama</option>
                            <option value="Mesa">Mesa</option>
                            <option value="Banho">Banho</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit"class="btn btn-primary">Atualizar</button>
                </form>
            </div>
        </div>
    </center>
</body>
</html>