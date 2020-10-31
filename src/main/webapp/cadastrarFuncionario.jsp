<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <div class="container">
        <h1>Cadastro de Funcionario</h1>
        </br>
        </br>
        <form method="POST" action="cadastrarFuncionario">

            <div class="row form-group">
                <div class="col-6">
                    <label for="cpf">Cpf do Funcionario</label>
                </div>
                <div class="col-6">
                    <label for="sexo">Sexo</label>
                </div>
            </div>
            <div class="row form-group">
                <div class="col-6 " > 
                    <input name="cpf" class="form-control" required="true" placeholder="000.000.000-00"></input>
                </div>
                <div class="col-6 " > 
                    <select class="form-control"  id="filtro">
                        <option value="op">-</option>
                        <option value="op">Masculino</option>
                        <option value="op">Feminino</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="nome">Nome do Funcionario</label>
                <input name="nome" class="form-control" required="true"></input>
            </div>

            <div class="row form-group">
                <div class="col-6">
                    <label for="data_nasc">Data de Nascimento</label>                    
                </div>

                <div class="col-6">
                    <label for="telefone">Telefone</label>
                </div>
            </div>

            <div class="row form-group">
                <div class="col-6">
                    <input name="data_nasc" type="date" class="form-control" required="true" placeholder="YY/mm/dd"></input>
                </div>
                <div class="col-6">
                    <input name="telefone" class="form-control" required="true" placeholder="0000-0000"></input>
                </div>
            </div>  

            <div class="form-group">
                <label for="endereco">Endereço</label>
                <input name="endereco" class="form-control" required="true"></input>
            </div>
            <br/>
            <button type="submit"  class="btn btn-primary">Enviar</button>
        </form>
    </div>