<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:choose>
            <c:when test="${sessionScope.user.cargo eq 'admin'}">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="protegido/index.jsp">T·Ligado</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListaCliente"/>">Listar Clientes</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarCliente.jsp"/>">Cadastrar Cliente</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Produto
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/listaProduto"/>">Listar Produtos</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarProduto.jsp"/>">Cadastrar Produto</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Venda
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/VendaServlet"/>">Realizar Venda</a>
                                <c:if test="${sessionScope.user.isGerenteG()}">
                                    <a class="dropdown-item" href="<c:url value="/ListarVendas"/>">RelatÛrios de Vendas</a>
                                </c:if>
                                <c:if test="${sessionScope.user.isGerenteF()}">
                                    <a class="dropdown-item" href="<c:url value="/ListarVendas"/>">RelatÛrios de Vendas</a>
                                </c:if>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Colaborador
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListarFuncionario"/>">Listar Colaboradores</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarFuncionario.jsp"/>">Cadastrar Colaborador</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Filial
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListarFilial"/>">Listar Filiais</a>
                                <a class="dropdown-item" href="<c:url value="/protegido/admin/cadastrarFilial.jsp"/>">Cadastrar Filiais</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav navbar-right">
                        <li class="nav-item">
                            <a class="nav-link">Seja bem-vindo(a) ${user.nomeFunc}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link">|</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/SairServlet"/>">Sair</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </c:when>
        <c:when test="${sessionScope.user.cargo eq 'Vendedor'}">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="protegido/index.jsp">T·Ligado</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListaCliente"/>">Listar Clientes</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarCliente.jsp"/>">Cadastrar Cliente</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Produto
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/listaProduto"/>">Listar Produtos</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarProduto.jsp"/>">Cadastrar Produto</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Venda
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/VendaServlet"/>">Realizar Venda</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav navbar-right">
                        <li class="nav-item">
                            <a class="nav-link">Seja bem-vindo(a) ${user.nomeFunc}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link">|</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/SairServlet"/>">Sair</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </c:when>
        <c:when test="${sessionScope.user.cargo eq 'Gerente Geral'}">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="protegido/index.jsp">T·Ligado</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">                       
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Venda
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListarVendas"/>">RelatÛrios de Vendas</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Colaborador
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListarFuncionario"/>">Listar Colaboradores</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Filial
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListarFilial"/>">Listar Filiais</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav navbar-right">
                        <li class="nav-item">
                            <a class="nav-link">Seja bem-vindo(a) ${user.nomeFunc}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link">|</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/SairServlet"/>">Sair</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </c:when>
        <c:when test="${sessionScope.user.cargo eq 'Analista de Rede'}">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="protegido/index.jsp">T·Ligado</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListaCliente"/>">Listar Clientes</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarCliente.jsp"/>">Cadastrar Cliente</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Produto
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/listaProduto"/>">Listar Produtos</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarProduto.jsp"/>">Cadastrar Produto</a>
                            </div>
                        </li>                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Colaborador
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListarFuncionario"/>">Listar Colaboradores</a>
                                <a class="dropdown-item" href="<c:url value="/cadastrarFuncionario.jsp"/>">Cadastrar Colaborador</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Filial
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="<c:url value="/ListarFilial"/>">Listar Filiais</a>
                                <a class="dropdown-item" href="<c:url value="/protegido/admin/cadastrarFilial.jsp"/>">Cadastrar Filiais</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav navbar-right">
                        <li class="nav-item">
                            <a class="nav-link">Seja bem-vindo(a) ${user.nomeFunc}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link">|</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/SairServlet"/>">Sair</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </c:when>
    </c:choose>
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
</body>
</html>

<style>
    body {
        background: #d3d3d3;
        height: 100vh;
    }
</style>