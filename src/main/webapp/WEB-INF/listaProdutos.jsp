<%-- 
    Document   : listaProdutos
    Created on : 19/10/2020, 15:25:20
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>

        <script lang="text/javascript">

            function mostrarModalExclusao(cod_produto, preco, descricao, qtd_estoque, nome_produto) {
                $("#cod_produtoe").html(cod_produto);
                $("#preco").val(preco);

                $('#modalExclusao').modal('show');
            }

            function excluirCliente() {
                var cpf = $("#cpfCliente").val();
                $.get("ExcluirCliente?cpf=" + cpf, function (resposta) {
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
    <body class="container">
        <h1>Lista de Produtos</h1>
        <table class="table">
            <thead>
            <th>Codigo</th>
            <th>Nome</th>
            <th>Descricao</th>
            <th>preco</th>
            <th>Quantidade</th>
        </thead>
        <tbody> 
        <c:forEach var="Produto" items="${listaProdutos}">
            <tr>
                <td>${cliente.nome}</td>
                <td>${cliente.email}</td>
                <td>${cliente.cpf}</td>
                <td><a href="AlterarCliente?cpf=${cliente.cpf}">Alterar</a></td>
                <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.cpf}, '${cliente.nome}')">Excluir</button></td>
            </tr>
        </c:forEach>

    </tbody>

</table>
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
                Confirmar exclusão do cliente  <label id="nomeCliente"></label> ?
                <input id="cpfCliente" hidden="true" />

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
            </div>
        </div>
    </div>
</div>
<br/>
<a href="index.jsp">Voltar</a>
</body>
</html>

