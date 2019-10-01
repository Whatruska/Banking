<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
    <%@include file="/Pages/Blocks/Head.jsp" %>
<body>
    <style>
        <%@ include file="/Pages/Styles/baseStyle.css" %>
    </style>
    <div class="container">
        <h1 class="container-item">Welcome</h1>
        <form class="container-item" action="${pageContext.request.contextPath}/register" method="get">
            <button type="submit">Register</button>
        </form>
        <form class="container-item" action="${pageContext.request.contextPath}/login" method="get">
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
