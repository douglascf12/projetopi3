<%-- 
    Document   : listaCliente
    Created on : 19/10/2020, 23:48:50
    Author     : andre
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        
         <script lang="text/javascript">
            
            function mostrarModalExclusao(cpf_cliente, nome){
                $("#nome").html(nome);
                $("#cpf_cliente").val(cpf_cliente);
                $('#modalExclusao').modal('show');
            }
            
            function excluirCliente() {
                var cpf_cliente = $("#cpf_cliente").val();
                $.get( "ExcluirCliente?cpf_cliente="+cpf_cliente, function( resposta ) {
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
    
     <body class="container">
       <h1>Lista de Clientes</h1>
        <table class="table">
            <thead>
                <th>Nome</th>
                <th>CPF</th>
                <th>Telefone</th>
                <th>Data de Nscimento</th>
                <th>Endereço</th>
                <th>Sexo</th>
            </thead>
            <tbody> 
                <c:forEach var="cliente" items="${listaClientes}">
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.cpf_cliente}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.data_nasc}</td>
                        <td>${cliente.endereco}</td>
                        <td>${cliente.sexo}</td>
                        <td><a href="AlterarCliente?cpf_cliente=${cliente.cpf_cliente}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.cpf_cliente}, '${cliente.nome}')">Excluir</button></td>
                    </tr>
                </c:forEach>
                
            </tbody>
            
        </table>
        <div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    Confirmar exclusão do cliente  <label id="nome"></label> ?
                    <input id="cpf_cliente" hidden="true" />
                 
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
                </div>
              </div>
            </div>
          </div>
        <br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
