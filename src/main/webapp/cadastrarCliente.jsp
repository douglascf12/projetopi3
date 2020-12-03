<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <div class="container">
            <h1>Cadastro</h1>
            <form action="CadastrarCliente" method="POST">
                <p>Nome</p>
                <input name="nome" class="form-control" required="true"/><br/>            
                <p>CPF</p>
                <input type="text" name="cpf_cliente"  class="form-control cpf-mask" required="true"/><br/>
                <p>Telefone</p>
                <input name="telefone" class="form-control phone-ddd-mask" required="true"/><br/>
                <p>data de Nascimento</p>                
                <input name="data_nasc" type="date" class="form-control date-mask" required="true" placeholder="YY/mm/dd">
                <p>Endereço</p>
                <input name="endereco" class="form-control" required="true"/><br/>
                <p>Sexo</p>                
               <select name="sexo" class="form-control" required="true"/><br/>
               <option value=" "></option>
               <option value="Feminino">Feminino</option>
               <option value="Masculino">Masculino</option>              
            </select><br/>                
                               
            </form>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
        
    </body>
</html>
