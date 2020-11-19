<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <div class="container">
        <h1>Alteração de Cadastro do ${func.nomeFunc}</h1>
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
                    <input class="form-control" name="cpf_func" value="${func.cpfFunc}" readonly="true"/><br/>
                </div>
                <div class="col-6 " > 
                    <select name="sexo" class="form-control"  id="sexo">
                        <option value="op">-</option>
                        <option value="op">Masculino</option>
                        <option value="op">Feminino</option>

                    </select>
                </div>
            </div>

            <!--<div class="form-group">
                <label for="cpf">Cpf do Funcionario</label>
                <input class="form-control" name="nome" value="${func.cpfFunc}" readonly="true"/><br/>
            </div>-->
            <div class="form-group">
                <label>Nome do Funcionario</label>
                <input class="form-control" name="nome" value="${func.nomeFunc}"/><br/>
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
                    <input class="form-control" type="date" name="data_nasc" value="${func.dataNascFunc}"/><br/>  
                </div>

                <div class="col-6">
                    <input class="form-control" name="telefone" value="${func.telefoneFunc}"/><br/>
                </div>
            </div>

            <!-- <div class="form-group">
                 <label>Data de Nascimento</label>
                 <input class="form-control" name="nome" value="${func.dataNascFunc}" readonly="true"/><br/>
             </div>-->
            <!-- <div class="form-group">
                 <label>Telefone</label>
                 <input class="form-control" name="nome" value="${func.telefoneFunc}" readonly="true"/><br/>
             </div>-->

            <div class="form-group">
                <label>Endereço</label>
                <input class="form-control" name="endereco" value="${func.enderecoFunc}"/><br/>
            </div>

            <div class="row form-group">
                <div class="col-6">
                    <label for="cargo">Cargo do Funcionário</label>
                </div>
                
                <div class="col-6">
                    <label for="filial">Filial que Trabalha</label>
                </div>

            </div>
            
            <div class="row form-group">
              <div class="col-6">
                    <input class="form-control" name="cargo" value="${func.cargo}"/><br/>
                    
              </div>
                <div class="col-6">
                     <input class="form-control" name="cod_filial" value="${func.codFilial}"/><br/>
                </div>
            
            
            </div>
                
                <div class="row form-group">
                <div class="col-6">
                    <label for="usuario">Usuário</label>
                </div>
                
                <div class="col-6">
                    <label for="senha">Senha</label>
                </div>

            </div>
            
            <div class="row form-group">
              <div class="col-6">
                    <input class="form-control" name="usuario" value="${func.usuario}" readonly="true"/><br/>
                    
              </div>
                <div class="col-6">
                     <input class="form-control" name="senha" value="${func.senha}" type="password"/><br/>
                </div>
            
            
            </div>

            <!--<div class="form-group">
                <label>Sexo</label>
                <input class="form-control" name="email" value="${func.sexoFunc}"/><br/>
            </div>-->

            <button type="submit" class="btn btn-primary">Alterar</button>
        </form>
    </div>