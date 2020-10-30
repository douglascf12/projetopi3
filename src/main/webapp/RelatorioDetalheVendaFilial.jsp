<%-- 
    Document   : RelatorioDetalheVenda
    Created on : 23/10/2020, 13:01:21
    Author     : w_olv
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <table class="table">
            <thead>
            <th>Cód. Filial</th>
            <th>Cód. Produto</th>
            <th>Data</th>
            <th>Qtd. Vendida</th>
            <th>Categoria</th>
        </thead>
        <h4>Vendas Filtradas</h4> 
        <tbody>
            <c:forEach var="v" items="${listaDetalheVendas}">
                <tr>
                    <td>${v.cod_filial}</td>
                    <td>${v.cod_produto}</td>
                    <td>${v.data_venda}</td>
                    <td>${v.qtd_vendida}</td>                
                    <td>${v.categoria}</td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="ListarVendas"><button type="button" class="btn btn-warning">Vendas</button></a></body>
</body>
</html>
