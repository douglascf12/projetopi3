<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div class="container">
        <table class="table">
            <thead>
            <th>Cód. Produto</th>
            <th>Cód. Venda</th>
            <th>Qtd. Vendida</th>
            <th>Sub Total</th>
            </thead>
            <h4>Detalhes da Venda</h4> 
            <tbody>
                <c:forEach var="v" items="${listaDetalheVendas}">
                    <tr>
                        <td>${v.codProduto}</td>
                        <td>${v.codVenda}</td>
                        <td>${v.quantidade}</td>                
                        <td>${v.subTotal}</td>                
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="ListarVendas"><button type="button" class="btn btn-warning">Vendas</button></a>
    </div>