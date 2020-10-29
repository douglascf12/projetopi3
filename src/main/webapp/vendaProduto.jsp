<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <script>
        function calcularSubTotal() {
            var qtd = parseInt(document.getElementById('quantidade').value, 10);
            var preco = parseFloat(document.getElementById('preco').value, 10);
            document.getElementById('subTotal').value = qtd * preco;
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venda</title>
    </head>
    <body class="container">

        <h3>Número da venda: ${idVenda}</h3>
        <form action="VendaProduto" method="GET" class="form-inline">
            <div class="card mt-3 w-100">
                <div class="card-header text-center">
                    <b>Dados do Produto</b>
                </div>

                <div class="card-body float-left w-100">

                    <div class="col-12 form-group mb-2">
                        <input type="hidden" name="idVenda" value="${idVenda}"/>
                        <input type="hidden" name="codigoFilial" value="${codigoFilial}"/>
                        <label type="text" class="input-group-text">Código</label>
                        <input type="search" id="codigo" name="codigoProduto" size="5" value="${produto.cod_produto}" class="form-control" required="required" />
                        <button type="submit" class="btn btn-primary">&#128269;</button><br/>
                    </div>
                    <div class="col-12 form-group mb-2">
                        <label for="nome-produto">Nome</label>
                        <input name="nome_produto" value="${produto.nome_produto}" class="form-control"/><br/>
                    </div>
                    <div class="form-group">
                        <div class="col-6 input-group mb-2">
                            <label for="produto-preco">Preço unitário</label>
                            <input name="preco" value="${produto.preco}" size="5" class="form-control"/><br/>
                        </div>
                    </div>
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
                        <th>Estoque</th>
                        </thead>
                        <tbody id="tbody"> 
                            <tr>
                                <td>${produto.cod_produto}</td>
                                <td>${produto.nome_produto}</td>
                                <td>${produto.preco}</td>
                                <td>${produto.qtd_estoque}</td>
                            </tr>
                        </tbody>
                    </table>

                    <br>

                </div>
            </div>
        </form>
        <br>
        <form action="VendaInserirProduto" method="POST" class="form-inline">
            <div class="card mt-3 w-100">
                <div class="col-12 form-group mb-2">
                    <input type="hidden" name="idVenda" value="${idVenda}"/>
                    <input type="hidden" name="codigoFilial" value="${codigoFilial}"/>
                    <input type="hidden" name="codigoProduto" value="${produto.cod_produto}"/>
                    <label>Quantidade</label>
                    <input size="5" class="form-control" id="quantidade" name="quantidade"  value="1" onfocus="calcularSubTotal()" required="required"/><br/>
                    <input type="hidden" id="preco" name="preco" value="${produto.preco}" onblur="calcularSubTotal()"/>
                </div>
                <div class="col-12 form-group mb-2">
                    <label>Sub-total: </label>
                    <input size="5" class="form-control" id="subTotal" name="subTotal" readonly="true"/>
                </div>
                <div class="col-12 form-group mb-2">
                    <button type="submit" class="btn btn-primary">Adicionar ao carrinho</button>
                </div>
            </div>
        </form>
        <br>
        <form action="VendaCarrinho" method="GET" class="form-inline">
            <input type="hidden" name="idVenda" value="${idVenda}"/>
            <input type="hidden" name="codigoFilial" value="${codigoFilial}"/>
            <button type="submit" class="btn btn-primary">Ver carrinho</button>
        </form>
        <a href="index.jsp">Voltar</a>
    </body>
</html>