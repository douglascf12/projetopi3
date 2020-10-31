<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <script>
        $(function () {
            var valorT = 0;
            $(".valorTotal").each(function () {
                valorT += parseFloat($(this).text());
            });
            document.getElementById('valorTo').value = valorT;
            document.getElementById('valorTo2').value = valorT;
        })
    </script>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venda</title>
    </head>
    <div class="container">
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
                                <td>${itemVenda.codProduto}</td>
                                <td>${itemVenda.nome}</td>
                                <td>${itemVenda.quantidade}</td>
                                <td>${itemVenda.preco}</td>
                                <td class="valorTotal">${itemVenda.subTotal}</td>
                            </tr>                            
                        </c:forEach>
                    </tbody>
            </div>
            </table>
            <br>
            <div class="col-4 form-group mb-2">
                <label>Valor total da venda: </label>
                <input size="5" class="form-control" id="valorTo" value="${valorT}" readonly="true"/>
            </div>
        </div>
        <br>
        <form action="VendaFinalizar" method="POST" class="form-inline">
            <input type="hidden" name="idVenda" value="${idVenda}"/>
            <input type="hidden" name="valorTotal" id="valorTo2" value="${valorT}"/>
            <button type="submit" class="btn btn-primary">Finalizar</button>
        </form>
    </div>