<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TáLigado - Realizar Venda</title>
    </head>
    <body>
    <center>
        <div class="card w-50">
            <h5 class="card-header">Pesquisar Cliente</h5>
            <div class="card-body">
                <form action="VendaServlet" method="GET">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">CPF</label>
                        <div class="col-sm-10">
                            <input name="cpf" placeholder="Pesquisar CPF" class="form-control"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Pesquisar</button>
                </form>
                <br>
                <form action="VendaServlet" method="POST">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">CPF</label>
                        <div class="col-sm-10">
                            <input name="cpf" class="form-control" value="${cliente.cpf_cliente}" readonly="true"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Nome</label>
                        <div class="col-sm-10">
                            <input name="nome" class="form-control" value="${cliente.nome}" readonly="true"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Próximo</button>
                </form>
            </div>
        </div>
    </center>
    </body>
</html>