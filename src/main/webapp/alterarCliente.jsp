<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <body>
        <h1>Alteração de Cadastro: ${cliente.cpf_cliente}</h1>
        <form action="AlterarCliente" method="POST">
            <p>Nome</p>
            <input name="nome" value="${cliente.nome}"/><br/>
            <p>CPF</p>
            <input name="cpf_cliente" value="${cliente.cpf_cliente}" readonly="true"/><br/>
            <p>Telefone</p>
            <input name="telefone" value="${cliente.telefone}"/><br/>
            <p>Data de Nascimento</p>
            <input name="data_nasc" value="${cliente.data_nasc}"/><br/>
            <p>Endereço</p>
            <input name="endereco" value="${cliente.endereco}"/><br/>
            <p>Sexo</p>
            <input name="sexo" value="${cliente.sexo}"/><br/>
            
            <button type="submit">Enviar</button>
            
        </form>
    </body>
</html>