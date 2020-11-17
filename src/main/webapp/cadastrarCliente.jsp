<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <div class="container">
            <h1>Cadastro</h1>
            <form action="CadastrarCliente" method="POST">
                <p>Nome</p>
                <input name="nome" class="form-control" required="true"/><br/>            
                <p>CPF</p>
                <input type="text" name="cpf_cliente"  class="form-control" required="true"/><br/>
                <p>Telefone</p>
                <input name="telefone" class="form-control" required="true"/><br/>
                <p>data de Nascimento</p>
                <input name="data_nasc" class="form-control" required="true"/><br/>
                <p>Endereço</p>
                <input name="endereco" class="form-control" required="true"/><br/>
                <p>Sexo</p>
                <input name="sexo" class="form-control" required="true"/><br/>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </body>
</html>
