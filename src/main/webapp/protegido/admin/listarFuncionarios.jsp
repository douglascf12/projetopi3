<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T�Ligado - Lista de Funcionarios</title>
        <script lang="text/javascript">
            function mostrarModalExclusao(cpf, nome) {
                $("#nome").html(nome);
                $("#cpf").val(cpf);
                $('#modalExclusao').modal('show');
            }
            function excluirFuncionario() {
                var cpf = $("#cpf").val();
                $.get("ExcluirFuncionario?cpf=" + cpf, function (resposta) {
                    $('#modalExclusao').modal('hide')
                    if (resposta === "true") {
                        console.log("Funfou!");
                    } else {
                        console.log("Ops!");
                    }
                    window.location.reload();
                });
            }
        </script>
    </head>
    <body>
    <center>
        <div class="card w-50">
            <h5 class="card-header">Lista de Funcion�rios</h5>
            <div class="card-body">
                <div class="container">
                    <table class="table table-hover">
                        <thead>
                        <th>CPF</th>
                        <th>Nome</th>
                        <th>Cargo</th>
                        <th>Filial</th>
                        <th>Usu�rio</th>
                        <th>A��es</th>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${sessionScope.user.cargo eq 'Gerente Geral'}">
                                    <c:forEach var="funcionario" items="${listaFuncionarios}">
                                            <tr>
                                                <td>${funcionario.cpfFunc}</td>
                                                <td>${funcionario.nomeFunc}</td>
                                                <td>${funcionario.cargo}</td>
                                                <td>${funcionario.codFilial}</td>
                                                <td>${funcionario.usuario}</td>
                                                <td>
                                                    <a href="AlterarFuncionario?cpf=${funcionario.cpfFunc}"><img src="imagens/icon_editar.png" alt="Editar"></a>
                                                </td>
                                            </tr>
                                    </c:forEach>
                                </c:when>
                                <c:when test="${sessionScope.user.cargo eq 'Gerente Filial'}">
                                    <c:forEach var="funcionario" items="${listaFuncionarios}">
                                        <c:if test="${sessionScope.user.codFilial == funcionario.codFilial}">
                                            <tr>
                                                <td>${funcionario.cpfFunc}</td>
                                                <td>${funcionario.nomeFunc}</td>
                                                <td>${funcionario.cargo}</td>
                                                <td>${funcionario.codFilial}</td>
                                                <td>${funcionario.usuario}</td>
                                                <td>
                                                    <a href="AlterarFuncionario?cpf=${funcionario.cpfFunc}"><img src="imagens/icon_editar.png" alt="Editar"></a>
                                                    <a><img onclick="mostrarModalExclusao(${funcionario.cpfFunc}, '${funcionario.nomeFunc}')" src="imagens/icon_excluir.png" alt="Excluir"></a>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </center>
</body>
</html>

<div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclus�o</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Confirmar exclus�o do Colaborador?
                <input name="cpf" id="cpf" hidden="true" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="excluirFuncionario()">Confirmar</button>
            </div>
        </div>
    </div>
</div>