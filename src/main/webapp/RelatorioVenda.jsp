<%-- 
    Document   : relatorioVenda
    Created on : 21/10/2020, 10:42:34
    Author     : w_olv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorios</title>
        <script lang="text/javascript">
            function venda(id_venda) {
                $.get("DetalharVenda?id_venda=" + id_venda, function( resposta ) {
                    
                });
            }
            ;
        </script>
    </head>
    <body class="container">
        <h4>Reltórios de Vendas</h4>
        <h6>Filtrar por período</h6>

        <table class="table">
            <thead>
            <th>Cód. Venda</th>
            <th>Cliente Cpf </th>
            <th>Funcionário Cpf</th>
            <th>Valor Total</th>
            <th>Detalhe Venda</th>
        </thead>
        <tbody>
            <c:forEach var="v" items="${listaVendas}">
                <tr>
                    <td>${v.id_venda}</td>
                    <td>${v.cpf_cliente}</td>
                    <td>${v.cpf_func}</td>
                    <td>${v.total_venda}</td>
                    <td><button type="button" class="btn btn-danger" onclick="venda(${v.id_venda})" >Detalhes</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>    
</table>
</body>
</html>
