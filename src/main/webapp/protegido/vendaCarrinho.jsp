<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <script>
        $(function () {
            var valorT = 0;
            $(".valorTotal").each(function () {
                valorT += parseFloat($(this).text());
            });
            document.getElementById('valorTo').value = valorT;
            document.getElementById('valorTo2').value = valorT;
        })

        function calcularSubTotal() {
            var qtdVendida = parseInt(document.getElementById('qtdVendida').value, 10);
            var preco = parseFloat(document.getElementById('preco').value, 10);
            document.getElementById('subTotal').value = qtdVendida * preco;
        }

        function mostrarModalVenda() {
            $('#modalVenda').modal('show');
        }

        function adicionarProdutoNaSessao(codigo) {
            var qtdVendida = parseInt(document.getElementById('qtdVendida').value, 10);
            var subTotal = parseFloat(document.getElementById('subTotal').value, 10);
            console.log(qtdVendida);
            $.get("CarrinhoServlet?codigo=" + codigo + "&qtdVendida=" + qtdVendida + "&subTotal=" + subTotal, function (resposta) {
                $('.toast').toast('show');
            })
            window.location.reload();
        }

        function cadastrarVendaServlet(totalVenda) {
            //var totalVenda = parseFloat(document.getElementById('totalVenda').value, 10);
            $.get("CadastrarVendaServlet?valorVenda=" + totalVenda, function (resposta) {
                $('.toast').toast('show');
            })
            window.location.reload();
        }

        function teste(cpfFuncionario, filialFuncionario) {
            var tabela = document.getElementById('tbCarrinho');
            var linhas = tabela.rows.length;
            for (var i = 1; i < linhas; i++) {
                var campo = document.querySelectorAll("tr");
                console.log(campo[i].cells[1]);
                console.log(campo[i].cells[2]);
                console.log(campo[i].cells[3]);
                console.log(campo[i].cells[4]);
                console.log(cpfFuncionario);
                console.log(filialFuncionario);
                $.get("CarrinhoServlet?codigo=" + codigo + "&qtdVendida=" + qtdVendida + "&subTotal=" + subTotal, function (resposta) {
                    $('.toast').toast('show');
                })
            }
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TáLigado - Realizar Venda</title>
    </head>
    <body>
    <center>
        <div class="card w-50">
            <h5 class="card-header">Pesquisar Produto</h5>
            <div class="card-body">
                <form action="VendaProduto" method="GET">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Código do Produto</label>
                        <div class="col-sm-10">
                            <input name="codProduto" placeholder="Código do Produto" class="form-control"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Pesquisar</button>
                </form>
                <br>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Nome</label>
                    <div class="col-sm-10">
                        <input name="cpf" class="form-control" value="${produto.nome_produto}" readonly="true"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Valor</label>
                    <div class="col-sm-10">
                        <input name="preco" class="form-control" value="${produto.preco}" readonly="true"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Estoque</label>
                    <div class="col-sm-10">
                        <input name="qtdEstoque" class="form-control" value="${produto.qtd_estoque}" readonly="true"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Quantidade</label>
                    <div class="col-sm-10">
                        <input class="form-control" id="qtdVendida" name="qtdVendida"  value="0" onfocus="calcularSubTotal()" required="required" />
                        <input type="hidden" id="preco" name="preco" value="${produto.preco}" onblur="calcularSubTotal()"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Sub-total</label>
                    <div class="col-sm-10">
                        <input id="subTotal" name="subTotal" class="form-control" readonly="true"/>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" onclick="adicionarProdutoNaSessao(${produto.cod_produto})">Adicionar no carrinho</button>
            </div>
        </div>
        <br>
        <div class="card w-50">
            <h5 class="card-header">Carrinho de Compras</h5>
            <div class="card-body">
                <div class="container">
                    <table class="table table-hover" id="tbCarrinho">
                        <thead>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Preço</th>
                        <th>Quantidade</th>
                        <th>Sub-Total</th>
                        <th>Ações</th>
                        </thead>
                        <tbody> 
                            <c:forEach var="p" items="${listaProdutos}">
                                <tr>
                                    <td>${p.cod_produto}</td>
                                    <td>${p.nome_produto}</td>
                                    <td>${p.preco}</td>
                                    <td>${p.qtd_vendida}</td>
                                    <td class="valorTotal">${p.subTotal}</td>
                                    <td>
                                        <a href="AlterarFilial?codigo=${filial.codigo}"><img src="imagens/icon_editar.png" alt="Editar"></a>
                                        <a><img onclick="mostrarModalVenda(${filial.codigo}, '${filial.nome}')" src="imagens/icon_excluir.png" alt="Excluir"></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="col-4 form-group mb-2">
                        <label>Valor total da venda: </label>
                        <input size="5" class="form-control" id="valorTo" value="${valorT}" readonly="true"/>
                    </div>
                    <form action="CadastrarVendaServlet" method="POST">
                        <input type="hidden" name="valorTotal" id="valorTo2" value="${valorT}"/>
                        <button type="submit" class="btn btn-primary">Finalizar</button>
                    </form>
                </div>
            </div>
        </div>
    </center>
</body>
</html>

<!-- Modal venda -->
<div class="modal fade" id="modalVenda" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Valor total: ${valorTotal}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Confirmar ?
                <input id="cod_produto" hidden="true" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <form action="CadastrarVendaServlet" method="POST">
                    <button type="button" class="btn btn-primary" >Confirmar</button>
                </form>

            </div>
        </div>
    </div>
</div>