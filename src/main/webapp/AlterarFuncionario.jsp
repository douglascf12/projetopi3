<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <div class="container">
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
                    <input class="form-control" name="cargo" value="${funcionario.cargoFunc}" readonly="true"/><br/>
                    
              </div>
                <div class="col-6">
                     <input class="form-control" name="filial" value="${funcionario.codFilial}" readonly="true"/><br/>
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
                    <input class="form-control" name="usuario" value="${funcionario.usuarioFunc}" readonly="true"/><br/>
                    
              </div>
                <div class="col-6">
                     <input class="form-control" name="senha" value="${funcionario.senhaFunc}" readonly="true"/><br/>
                </div>
            
            
            </div>

            <!--<div class="form-group">
                <label>Sexo</label>
                <input class="form-control" name="email" value="${funcionario.sexoFunc}"/><br/>
            </div>-->

            <button type="submit" class="btn btn-primary">Alterar</button>
        </form>
    </div>