<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Filial</title>
    </head>
    <div class="container">
        <h1>Alteração Cadastro de Filial <br/></h1>
        <form action="AlterarFilial" method="POST">
            <p>Código</p>
            <input name="codigo" class="form-control" value="${filial.codigo}" readonly="true" /><br/>
            <p>Nome</p>
            <input name="nome" class="form-control"  value="${filial.nome}"/><br/>
            <p>Estado</p>
            <input name="estado" class="form-control"  value="${filial.estado}"/><br/>
            <p>Cidade</p>
            <input name="cidade" class="form-control"  value="${filial.cidade}"/><br/>
            <br/>
            <br/>
            <button type="submit"class="btn btn-primary">Enviar</button>
        </form>
    </div>