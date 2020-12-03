<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T·Ligado - Home</title>
    </head>
    <body>
        <br>
        <br>
    <center>
        <h1>Seja bem-vinda(o) a rede T·Ligado!</h1>
        <br>
        <c:if test="${sessionScope.user.cargo != 'Gerente Geral'}">
            <h2>Loja: ${sessionScope.f.nome}</h2>
        </c:if>
    </center>
</body>
</html>