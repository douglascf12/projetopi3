<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T·Ligado - Login</title>
        <script>
            function verSenha() {
                var x = document.getElementById("senha");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>

        <div class="card text-center" style="width: 18rem;">
            <h5 class="card-header">Login</h5>
            <div class="card-body">
                <form action="LoginServlet" method="POST">
                    <p class="card-text"><input class="form-control" name="usuario" placeholder="Usu·rio" required ></p>
                    <p class="card-text"><input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" required ></p>
                    <p class="card-text"><input type="checkbox" onclick="verSenha()"> ver senha</p>
                    <button type="submit" class="btn btn-primary">Logar</button>
                </form>
            </div>
            <c:if test="${not empty param.erro}">
                <div class="alert alert-danger" role="alert">
                    Usu·rio/Senha inv·lido(s)!!!
                </div>
            </c:if>
        </div>
    </body>
</html>

<style>
    body {
        margin: 0;
        padding: 0;
        background:#d3d3d3;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
</style>