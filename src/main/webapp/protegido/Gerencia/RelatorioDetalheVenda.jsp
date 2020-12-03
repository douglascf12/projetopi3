<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <c:if test="${sessionScope.user.isGerenteF()}">
        <script>
            window.location.href = "DetalharVendaFilial?cod_filial=" + ${sessionScope.user.codFilial};
        </script>
    </c:if>
    <c:if test="${sessionScope.user.isVendedor()}">
        <script>
            window.location.href = "acessoNaoAutorizado.jsp";
        </script>
    </c:if>
    <c:if test="${sessionScope.user.isAnalista()}">
        <script>
            window.location.href = "acessoNaoAutorizado.jsp";
        </script>
    </c:if>
    <div class="container">
        <table class="table">
            <thead>
            <th>Cód. Produto</th>
            <th>Nome</th>
            <th>Cód. Venda</th>
            <th>Qtd. Vendida</th>
            <th>Sub Total</th>
            </thead>
            <h4>Detalhes da Venda</h4> 
            <tbody>
                <c:forEach var="v" items="${listaDetalheVendas}">
                    <tr>
                        <td>${v.cod_produto}</td>
                        <td>${v.nome}</td>
                        <td>${v.id_venda}</td>
                        <td>${v.qtd_vendida}</td>                
                        <td>${v.subTotal}</td>                
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="ListarVendas"><button type="button" class="btn btn-warning">Vendas</button></a>
    </div>