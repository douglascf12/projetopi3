<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <script lang="text/javascript">
        function mostrarModalExclusao(idItem, codProduto, quantidade) {
            $("#idItem").val(idItem);
            $("#codProduto").val(codProduto);
            $("#quantidade").val(quantidade);
            $('#modalExclusao').modal('show');
        }
        function excluirItemVenda() {
            var idItem = $("#idItem").val();
            var codProduto = $("#codProduto").val();
            var quantidade = $("#quantidade").val();
            $.get("VendaExcluirItem?idItem=" + idItem + "&codProduto=" + codProduto + "&quantidade=" + quantidade, function (resposta) {
                $('#modalExclusao').modal('hide')
                if (resposta === "true") {
                    console.log("Excluído com sucesso!");
                } else {
                    console.log("Erro ao excluir o produto");
                }
                window.location.reload();
            });
        }
        $(function () {
            var valorCalculado = 0;
            $(".valor-calculado").each(function () {
                valorCalculado += parseFloat($(this).text());
            });
            document.getElementById('valorTotal').value = valorCalculado;
        });
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venda</title>
    </head>
    <body class="container">

        <h3>Número da venda: ${idVenda}</h3>
        <div class="card mt-3 w-100">
            <div class="card-header text-center">
                <b>Lista de Produtos</b>
            </div>
            <div class="card-body float-left w-100">
                <table class="table table-hover overflow-auto">
                    <thead>
                    <th>Código do Produto</th>
                    <th>Nome do Produto</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                    <th>Sub-Total</th>
                    <th>Excluir</th>
                    </thead>
                    <tbody id="tbody">
                        <c:forEach var="itemVenda" items="${listaItemVenda}">
                            <tr>
                                <td>${itemVenda.cod_produto}</td>
                                <td>${itemVenda.nome}</td>
                                <td>${itemVenda.quantidade}</td>
                                <td>${itemVenda.qtd_estoque}</td>
                                <td class="valor-calculado">${itemVenda.subTotal}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <br>

            </div>
        </div>
        <br>
        <form action="VendaFinalizar" method="POST" class="form-inline">
            <input type="hidden" name="idVenda" value="${idVenda}"/>
            <input type="hidden" name="codigoFilial" value="${codigoFilial}"/>
            <button type="submit" class="btn btn-primary">Finalizar</button>
        </form>
        <br>
        <a href="index.jsp">Voltar</a>
    </body>
</html>