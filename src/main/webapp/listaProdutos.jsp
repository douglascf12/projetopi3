<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
        <script lang="text/javascript">
            function mostrarModalExclusao(cod_produto, nome_produto) {
                $("#nome_produto").html(nome_produto);
                $("#cod_produto").val(cod_produto);
                $('#modalExclusao').modal('show');
            }
            function excluirProduto() {
                var cod_produto = $("#cod_produto").val();
                $.get("ExcluirProduto?cod_produto=" + cod_produto, function (resposta) {
                    $('#modalExclusao').modal('hide')
                    if (resposta === "true") {
                        console.log("Funfou!");
                    } else {
                        console.log("Ops!");
                    }
                    window.location.reload();
                });
            }
        </script>
    </head>
    <body>
    <center>
        <div class="card w-75">
            <h5 class="card-header">Lista de Produtos</h5>
            <div class="card-body">
                <div class="container">
                    <table class="table table-hover">
                        <thead>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th>Qtd. Estoque</th>
                        <th>Categoria</th>
                        <th>Ações</th>
                        </thead>
                        <tbody> 
                            <c:forEach var="produto" items="${listaProdutos}">
                                <c:if test="${sessionScope.user.codFilial == produto.cod_filial}">
                                    <tr>
                                        <td>${produto.cod_produto}</td>
                                        <td>${produto.nome_produto}</td>
                                        <td>${produto.descricao}</td>
                                        <td>${produto.preco}</td>
                                        <td>${produto.qtd_estoque}</td>
                                        <td>${produto.categoria}</td>
                                        <td>
                                            <a href="AlterarProduto?cod_produto=${produto.cod_produto}"><img src="imagens/icon_editar.png" alt="Editar"></a>
                                            <a><img onclick="mostrarModalExclusao(${produto.cod_produto}, '${produto.nome_produto}')" src="imagens/icon_excluir.png" alt="Excluir"></a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </center>
</body>
</html>

<div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Confirmar exclusão do Produto  <label id="cod_produto"></label> ?
                <input id="cod_produto" hidden="true" />

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="excluirProduto()">Confirmar</button>
            </div>
        </div>
    </div>
</div>