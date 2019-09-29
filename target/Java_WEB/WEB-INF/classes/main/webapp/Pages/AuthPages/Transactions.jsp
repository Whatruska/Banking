<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<style>
    <%@ include file="/Pages/Styles/baseStyle.css" %>
</style>
<div class="container">
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/transactions" method="post">
        <div class="input-field">
            <label for="cardNum">Destination card number :</label>
            <input type="text" id="cardNum" placeholder="7777 0000 1111 2222" name="cardNum">
        </div>

        <div class="input-field">
            <label for="value">Value :</label>
            <input type="number" id="value" name="value">
        </div>

        <button type="submit">Perform</button>
    </form>
</div>
</body>
</html>
