<%-- 
    Document   : AlterarFuncionario
    Created on : 23/10/2020, 18:00:23
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="header.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <body class="container">
        <h1>Alteração de Cadastro do ${funcionario.nomeFunc}</h1>
        <form action="AlterarFuncionario" method="POST">

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
                    <input class="form-control" name="nome" value="${funcionario.cpfFunc}" readonly="true"/><br/>
                </div>
                <div class="col-6 " > 
                    <select class="form-control"  id="filtro">
                        <option value="op">-</option>
                        <option value="op">Masculino</option>
                        <option value="op">Feminino</option>

                    </select>

                </div>
            </div>





            <!--<div class="form-group">
                <label for="cpf">Cpf do Funcionario</label>
                <input class="form-control" name="nome" value="${funcionario.cpfFunc}" readonly="true"/><br/>
            </div>-->
            <div class="form-group">
                <label>Nome do Funcioanrio</label>
                <input class="form-control" name="nome" value="${funcionario.nomeFunc}" readonly="true"/><br/>
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
                    <input class="form-control" type="date" name="nome" value="${funcionario.dataNascFunc}" readonly="true"/><br/>  
                </div>

                <div class="col-6">
                    <input class="form-control" name="nome" value="${funcionario.telefoneFunc}" readonly="true"/><br/>
                </div>

            </div> 




            <!-- <div class="form-group">
                 <label>Data de Nascimento</label>
                 <input class="form-control" name="nome" value="${funcionario.dataNascFunc}" readonly="true"/><br/>
             </div>-->
            <!-- <div class="form-group">
                 <label>Telefone</label>
                 <input class="form-control" name="nome" value="${funcionario.telefoneFunc}" readonly="true"/><br/>
             </div>-->

            <div class="form-group">
                <label>Endereço</label>
                <input class="form-control" name="nome" value="${funcionario.enderecoFunc}" readonly="true"/><br/>
            </div>

            <!--<div class="form-group">
                <label>Sexo</label>
                <input class="form-control" name="email" value="${funcionario.sexoFunc}"/><br/>
            </div>-->

            <button type="submit" class="btn btn-primary">Alterar</button>


        </form>
    </body>
</html>
