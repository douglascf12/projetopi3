<%-- 
    Document   : RelatorioDetalheVenda
    Created on : 23/10/2020, 13:01:21
    Author     : w_olv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table">
        <thead>
        <th>Cód. Produto</th>
        <th>Data</th>
        <th>Qtd. Vendida</th>
    </thead>
    <h4>Detalhes da Venda</h4> 
    <tbody>
        <c:forEach var="v" items="${listaDetalheVendas}">
            <tr>
                <td>${v.cod_produto}</td>
                <td>${v.data_venda}</td>
                <td>${v.qtd_vendida}</td>                
            </tr>
        </c:forEach>
    </tbody>
    </body>
</html>
