<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionarios</title>
    </head>
    <div class="container">
        <h1>Lista de Funcionarios</h1>
        <table class="table">
            <thead>
            <th>Cpf</th>
            <th>Nome</th>
            <th>Data de Nascimento</th>
            <th>Telefone</th>
            <th>Endereço</th>
            <th>Sexo</th>
            </thead>
            <tbody>
                <c:forEach var="funcionario" items="${listaFuncionarios}">
                    <tr>
                        <td>${funcionario.cpfFunc}</td>
                        <td>${funcionario.nomeFunc}</td>
                        <td>${funcionario.dataNascFunc}</td>
                        <td>${funcionario.telefoneFunc}</td>
                        <td>${funcionario.enderecoFunc}</td>
                        <td>${funcionario.sexoFunc}</td>
                        <td><a href="AlterarCliente?nome=${funcionario.nome}">Alterar</a></td>
                        <td><a href="ExcluirFuncionario?nome=${funcioanrio.nome }">Excluir</a></td>
                    </tr>
                </c:forEach >
            </tbody>
        </table>
    </div>