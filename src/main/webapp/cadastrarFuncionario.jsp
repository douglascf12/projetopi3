<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <script>
        function validarForm() {
            var optionSelect = document.getElementById("cargoSelect").value;

            if (optionSelect === "Gerente Geral" || optionSelect=="1") {
                document.getElementById("filialSelect").value = null;
                document.getElementById("filialSelect").disabled = true;
            } else {
                document.getElementById("filialSelect").disabled = false;
            }
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <div class="container">
        <h1>Cadastro de Funcionario</h1>

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
                    <select name="sexo" class="form-control" id="sexo" required>
                        <option value="" selected></option>
                        <option value="Masculino">Masculino</option>
                        <option value="Feminino">Feminino</option>
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
                <label for="endereco">Endere�o</label>
                <input name="endereco" class="form-control" required="true"></input>
            </div>

            <div class="row form-group">
                <div class="col-6">
                    <label for="cargo">Cargo do Funcionario</label>                    
                </div>

                <div class="col-6">
                    <label for="cod_filial">Filial que Trabalha</label>
                </div>
            </div>

            <div class="row form-group">
                <div class="col-6">
                    <select id="cargoSelect" name="cargoSelect" onchange="validarForm()" class="form-control" required>
                        <option value="1" selected></option> 
                        <option value="Vendedor">Vendedor</option> 
                        <option value="Analista de Rede">Analista de Rede</option> 
                        <option value="Gerente Filial">Gerente Filial</option>
                        <option value="Gerente Geral">Gerente Geral</option>
                    </select>  
                </div>
                <div class="col-6">
                    <input id="filialSelect" name="cod_filial" class="form-control" required="true" disabled></input>
                </div>
            </div>  
            <div class="row form-group">
                <div class="col-6">
                    <label for="cargo">Usu�rio</label>                    
                </div>

                <div class="col-6">
                    <label for="cod_filial">Senha</label>
                </div>
            </div>

            <div class="row form-group">
                <div class="col-6">
                    <input name="usuario" class="form-control" required="true" ></input>
                </div>
                <div class="col-6">
                    <input name="senha" class="form-control" required="true" type="password" ></input>
                </div>
            </div>   
            <br/>
            <button type="submit"  class="btn btn-primary">Enviar</button>
        </form>
    </div>