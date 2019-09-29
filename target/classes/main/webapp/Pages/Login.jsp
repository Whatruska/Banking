<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <style>
        <%@ include file="/Pages/Styles/baseStyle.css" %>
    </style>
    <div class="container">
        <h1>Login</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="input-field">
                <label for="phone">Your phone :</label>
                <input type="tel" id="phone" placeholder="+12345678901" name="phone">
            </div>

            <div class="input-field">
                <label for="password">Your password :</label>
                <input type="password" id="password" name="password">
            </div>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
