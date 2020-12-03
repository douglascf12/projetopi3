<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>
    <center>
        <div class="card w-50">
            <h5 class="card-header">Cadastro de Produto</h5>
            <div class="card-body">
                <form action="cadastrarProduto" method="POST">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Nome</label>
                        <div class="col-sm-10">
                            <input name="nome_produto" class="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Descrição</label>
                        <div class="col-sm-10">
                            <input name="descricao" class="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Preço</label>
                        <div class="col-sm-10">
                            <input name="preco" class="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Quantidade em estoque</label>
                        <div class="col-sm-10">
                            <input name="qtd_estoque" class="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Categoria</label>
                        <div class="col-sm-10">
                            <select name="categoria" class="form-control" required="true"/>
                            <option value="Cama">Cama</option>
                            <option value="Mesa">Mesa</option>
                            <option value="Banho">Banho</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>
            </div>
        </div>
    </center>
</body>
</html>