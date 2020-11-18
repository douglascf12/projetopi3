<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div class="container">
        <h3>Categoria:${Categoria}</h3>
        <table class="table">
            <thead>
            <th>Nome</th>
            <th>Data</th>
            <th>Qtd. Vendida</th>
            <th>Sub Total</th>
            </thead>
            <h4>Detalhes da Venda</h4> 
            <tbody>
                <c:forEach var="v" items="${listaVendas}">
                    <tr>
                        <td>${v.nome}</td>
                        <td>${v.data_venda}</td>
                        <td>${v.qtd_vendida}</td>                
                        <td>${v.subTotal}</td>                
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="ListarVendas"><button type="button" class="btn btn-warning">Vendas</button></a>
    </div>