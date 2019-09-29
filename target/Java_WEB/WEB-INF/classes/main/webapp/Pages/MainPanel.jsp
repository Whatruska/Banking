<%@ page import="main.webapp.Backend.Banking.Client.Client" %>
<head>
    <jsp:useBean id="client" class="main.webapp.Backend.Banking.Client.Client" scope="session"></jsp:useBean>
    <%
        client = (Client) request.getSession().getAttribute("client");
    %>
    <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Main panel</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <style>
        <%@ include file="/Pages/Styles/baseStyle.css" %>
    </style>
    <div class="container">
        <h1 class="container-item">Main panel</h1>
        <h2 class="container-item">Hello, ${client.name}</h2>

        <form class="container-item" action="${pageContext.request.contextPath}/info" method="get">
            <button type="submit">Info</button>
        </form>

        <form class="container-item" action="${pageContext.request.contextPath}/transactions" method="get">
            <button type="submit">Transaction</button>
        </form>

        <form class="container-item" action="${pageContext.request.contextPath}/changeInfo" method="get">
            <button type="submit">Change info</button>
        </form>

        <form class="container-item" action="${pageContext.request.contextPath}/admin" method="get">
            <button type="submit">Admin</button>
        </form>
    </div>
</body>
</html>
