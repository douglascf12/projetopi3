<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Filial</title>
    </head>
    <div class="container">
        <h1>Cadastro</h1>
        <form action="CadastrarFilial" method="POST">
            <p>Nome</p>
            <input name="nome" class="form-control" required="true"/><br/>            
            <p>Estado</p>
            <input name="estado" class="form-control" required="true"/><br/>
            <p>Cidade</p>
            <input name="cidade" class="form-control" required="true"/><br/>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>