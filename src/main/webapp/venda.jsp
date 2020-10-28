<%-- 
    Document   : venda
    Created on : 23/10/2020, 14:30:42
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venda</title>
        <script lang="text/javascript">
            function pesquisarCliente(cpf) {
                $("#cpf_cliente").val(cpf);
                $.get("PesquisarCliente?cpf_cliente=" + cpf);
            }
            
            function pesquisarProduto(codigo) {
                $("#cod_produto").val(codigo);
                $.get("PesquisarProduto?cod_produto=" + codigo);
            }
            
            function cadastrarCliente() {
                $.get("ListaCliente?cpf_cliente=" + cpf);
            }
            
            
        </script>
    </head>
    <body class="container">
        <div class="card mt-3 w-100">
            <div class="card-header text-center">
                <b>Dados do Cliente</b>
            </div>
            <div class="card-body float-left w-100">
                <form action="PesquisarCliente" method="GET" class="form-inline">
                    <div class="col-12 form-group mb-2">
                        <label type="text" for="cpf" class="input-group-text">CPF</label>
                        <input type="search" id="cpf" name="cpf_cliente" size="15" placeholder="000.000.000-00" value="${cliente.cpf_cliente}" class="form-control" onclick="pesquisarCliente(cliente.cpf_cliente);"/>
                        <button type="submit" class="btn btn-primary">&#128269;</button><br/>
                    </div>
                    <div class="col-12 form-group mb-2">
                        <label for="nome-produto">Nome</label>
                        <input name="nome" value="${cliente.nome}" class="form-control"/><br/>
                    </div>
                    <div>
                        <button type="button" class="btn btn-primary" onclick="window.location.href = 'cadastrarCliente.jsp'">Cadastrar</button>
                    </div>
                </form>
            </div>
        </div>
        <br>   
        <div class="card mt-3 w-100">
            <div class="card-header text-center">
                <b>Dados do Produto</b>
            </div>
            <div class="card-body float-left w-100">
                <form action="PesquisarProduto" method="GET" class="form-inline">
                    <div class="col-12 form-group mb-2">
                        <label type="text" for="codigo" class="input-group-text">Código</label>
                        <input type="search" id="codigo" name="cod_produto" size="5" value="${produto.cod_produto}" class="form-control" required="required" onclick="pesquisarProduto(produto.cod_produto), pesquisarCliente(cliente.cpf_cliente);"/>
                        <button type="submit" class="btn btn-primary">&#128269;</button><br/>
                    </div>
                    <div class="col-12 form-group mb-2">
                        <label for="nome-produto">Nome</label>
                        <input name="nome_produto" value="${produto.nome_produto}" class="form-control"/><br/>
                    </div>
                    <div class="form-group">
                        <div class="col-6 input-group mb-2">
                            <label for="produto-preco">Preço unitário</label>
                            <input name="preco" value="${produto.preco}" class="form-control"/><br/>
                        </div>
                        <div class="col-6 input-group mb-2">
                            <label for="prdouto-quantidade">Quantidade</label>
                            <input name="qtd_produto" class="form-control" required="required" /><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>              
        <br>
        <div class="card mt-3 w-100">
            <div class="card-header text-center">
                <b>Lista de Produtos</b>
            </div>
            <div class="card-body float-left w-100">
                <table class="table table-hover overflow-auto">
                <thead>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Valor unitário</th>
                    <th>Quantidade</th>
                </thead>
                <tbody id="tbody"> 
                    <c:forEach var="item" items="${itens}">
                        <tr>
                            <td>${item.produto.cod_produto}</td>
                            <td>${item.produto.nome_produto}</td>
                            <td>${item.produto.preco}</td>
                            <td>${item.quantidade}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
            </div>
        </div>
        <br>
        <div class="card mt-3 w-100">
            <div class="card-header text-center">
                <b>Total da Venda</b>
            </div>
            <div class="card-body float-left w-100">
                <form class="form-inline">
                    <div class="col-6 form-group mb-2">
                        <label class="form-check-label" for="dt_in"><b>Data da Venda: </b></label>
                        <input type="date" class="form-control" id="dt_in">
                    </div>
                    <div class="col-6 form-group mb-2">
                        <label class="form-check-label" for="dt_in"><b>Valor Total: </b></label>
                        <input type="text" class="form-control" id="dt_in">
                    </div>
                </form>
            </div>
        </div>
        <br>
        <a href="index.jsp">Voltar</a>
    </body>
</html>