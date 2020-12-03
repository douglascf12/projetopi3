<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <body>
    <center>
        <div class="card w-75">
            <h5 class="card-header">Alteração de Cadastro: ${cliente.cpf_cliente}</h5>
            <div class="card-body">
                <form action="AlterarCliente" method="POST">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">CPF</label>
                        <div class="col-sm-10">
                            <input name="cpf_cliente" class="form-control" value="${cliente.cpf_cliente}" readonly="true"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Nome</label>
                        <div class="col-sm-10">
                            <input name="nome" class="form-control" value="${cliente.nome}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Telefone</label>
                        <div class="col-sm-10">
                            <input name="telefone" class="form-control phone-ddd-mask" value="${cliente.telefone}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Data de Nascimento</label>
                        <div class="col-sm-10">
                            <input name="data_nasc" class="form-control date-mask" value="${cliente.data_nasc}"/>
                        </div>                            
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Endereço</label>
                        <div class="col-sm-10">
                            <input name="endereco" class="form-control" value="${cliente.endereco}"/>
                        </div>                            
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Sexo</label>
                        <div class="col-sm-10">
                            <select name="sexo" class="form-control" required="true"/><br/>
                            <option value=" "></option>
                            <option value="Feminino">Feminino</option>
                            <option value="Masculino">Masculino</option>              
                            </select><br/> 
                        </div>                            
                    </div>
                    <button type="submit"class="btn btn-primary">Atualizar</button>
                </form>
            </div>
        </div>
    </center>   
    <script type="text/javascript" src="//code.jquery.com/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="//assets.locaweb.com.br/locastyle/2.0.6/javascripts/locastyle.js"></script>
    <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>