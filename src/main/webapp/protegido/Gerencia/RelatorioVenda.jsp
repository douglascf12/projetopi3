<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorios</title>
        <style>
            #Cliente, #Categoria, #Filial {
                display: none;
            }
        </style>
        <script lang="text/javascript">

            function tipo() {
                var select = document.getElementById('filtro');
                var option = select.children[select.selectedIndex];
                var texto = option.textContent;
                console.log(texto);
                //  
                if (texto === '-') {
                    document.getElementById('Categoria').style.display = "none";
                    document.getElementById('Cliente').style.display = "none";
                    document.getElementById('Filial').style.display = "none";
                } else if (texto === 'Cliente') {
                    document.getElementById('Categoria').style.display = "none";
                    document.getElementById('Filial').style.display = "none";
                } else if (texto === 'Categoria') {
                    document.getElementById('Cliente').style.display = "none";
                    document.getElementById('Filial').style.display = "none";
                } else {
                    document.getElementById('Categoria').style.display = "none";
                    document.getElementById('Cliente').style.display = "none";
                }
                document.getElementById(texto).style.display = "block";
            }
            ;
            function filtraPorCliente() {
                var campo = document.getElementById('campoCpf');
                window.location.href = "DetalharVendaCliente?cpf_cliente=" + campo.value;
            }
            function filtraPorProduto() {
                var select = document.getElementById('produto');
                var option = select.children[select.selectedIndex];
                var texto = option.textContent;
                window.location.href = "DetalharVendaProduto?Categoria=" + texto;
            }
            function filtraPorFilial() {
                var campo = document.getElementById('campoFilial');
                window.location.href = "DetalharVendaFilial?cod_filial=" + campo.value;
            }
            function teste() {
                for (var i = 0, row; row = table.rows[i]; i++) {
                    console.log(row.cells[0]);
                    console.log(row.cells[1]);
                    console.log(row.cells[2]);
                    console.log(row.cells[3]);

                }
            }

        </script>
    </head>

    <div class="container">
        <div>
            <h6>Filtrar por:</h6>
            <select class="form-control col-5" id="filtro">
                <option value="op">-</option>
                <option value="op">Filial</option>
                <option value="op">Categoria</option>
                <option value="op">Cliente</option>
            </select>
            <button onclick="tipo()" type="submit" class="btn btn-primary">&#128269;</button>
        </div>
        <div id="Categoria">
            <legend>Dados do Produto</legend>
            <select class="form-control col-5" id="produto">
                <option value="op">-</option>
                <option value="op">Cama</option>
                <option value="op">Mesa</option>
                <option value="op">Banho</option>                
            </select>
            <button onclick="filtraPorProduto()" type="submit" class="btn btn-primary">&#128269;</button>
        </div>
        <div id="Cliente">            
            <div class="input-group mb-3">
                <p><input type="search" id="campoCpf" name="cpf_cliente" size="15" placeholder="000.000.000-00" value="" class="form-control"/></p>
                <p><button type="submit" onclick="filtraPorCliente()" class="btn btn-primary">&#128269;</button></p>
            </div>
        </div>  
        <div class="row" id="Filial">
            <div class="col-1">
                <label type="text" class="input-group-text">ID</label>
                <input type="search" id="campoFilial" name="cpf_cliente" size="2" class="form-control"/>
                <button type="submit" onclick="filtraPorFilial()" class="btn btn-primary">&#128269;</button><br/>
            </div>

        </div>

        <h4>Reltórios de Vendas</h4>
        <h6>Filtrar por período</h6>

        <table id="table" class="table">
            <thead>
            <th>Cód. Venda</th>
            <th>Cliente Cpf </th>
            <th>Funcionário Cpf</th>
            <th>Data</th>
            <th>Valor Total</th>
            <th>Detalhe Venda</th>
            </thead>
            <tbody>
                <c:forEach var="v" items="${listaVendas}">
                    <tr>
                        <td>${v.id_venda}</td>
                        <td>${v.cpf_cliente}</td>
                        <td>${v.cpf_func}</td>
                        <td>${v.data_venda}</td>
                        <td>${v.total_venda}</td>
                        <td><a href="DetalharVenda?id_venda=${v.id_venda}"><button type="button" class="btn btn-danger">Detalhes</button></a></td>
                    </tr>
                </c:forEach>
            </tbody>
            <button onclick="teste()" type="submit" class="btn btn-primary">&#128269;</button>
        </table>
    </div>