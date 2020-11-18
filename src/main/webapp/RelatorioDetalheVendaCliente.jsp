<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div class="container">
        <h3>Vendas no CPF: ${cpf_cliente}</h3>
        <table id="table" class="table">
            <thead>
            <th>Cód. Venda</th>
            <th>Cliente Cpf </th>
            <th>Funcionário Cpf</th>
            <th>Data</th>
            <th>Valor Total</th>
            <th>Detalhe Venda</th>
            </thead>
            <tbody>
                <c:forEach var="v" items="${listaVendas}">
                    <tr>
                        <td>${v.id_venda}</td>
                        <td>${v.cpf_cliente}</td>
                        <td>${v.cpf_func}</td>
                        <td>${v.data_venda}</td>
                        <td>${v.total_venda}</td>
                        <td><a href="DetalharVenda?id_venda=${v.id_venda}"><button type="button" class="btn btn-danger">Detalhes</button></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            <a href="ListarVendas"><button type="button" class="btn btn-warning">Vendas</button></a>
    </div>