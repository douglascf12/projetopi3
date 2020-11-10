<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TáLigado - Alterar Filial</title>
    </head>
    <body>
        <center>
            <div class="card w-50">
                <h5 class="card-header">Alteração Cadastro de Filial</h5>
                <div class="card-body">
                    <form action="AlterarFilial" method="POST">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Código</label>
                            <div class="col-sm-10">
                                <input name="codigo" class="form-control" value="${filial.codigo}" readonly="true"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Nome</label>
                            <div class="col-sm-10">
                                <input name="nome" class="form-control"  value="${filial.nome}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Estado</label>
                            <div class="col-sm-10">
                                <input name="estado" class="form-control"  value="${filial.estado}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Cidade</label>
                            <div class="col-sm-10">
                                <input name="cidade" class="form-control"  value="${filial.cidade}"/>
                            </div>
                        </div>
                        <button type="submit"class="btn btn-primary">Atualizar</button>
                    </form>
                </div>
            </div>
        </center>
    </body>
</html>