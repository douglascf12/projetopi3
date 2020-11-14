<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venda</title>
    </head>
    <body>
    <center>
        <div class="card w-50">
            <h5 class="card-header">Cliente</h5>
            <div class="card-body">
                <form action="VendaServlet" method="GET" class="form-inline">
                    <input type="search" name="cpf" placeholder="Pesquisar CPF" value="${cliente.cpf_cliente}" class="form-control"/>
                    <button type="submit" class="btn btn-primary">&#128269;</button><br/>
                </form>
                <p class="card-text"><b>CPF:</b> ${cliente.cpf_cliente}</p>
                <p class="card-text"><b>Nome:</b> ${cliente.nome}</p>
                <form action="VendaServlet" method="POST" class="form-inline">
                    <input type="hidden" name="cpf" value="${cliente.cpf_cliente}"/>
                    <button type="submit" class="btn btn-primary">Próximo</button>
                </form>
            </div>
        </div>
    </center>
</body>
</html>