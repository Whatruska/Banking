<%@ page import="main.webapp.Backend.Banking.Client.Client" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
<head>
    <jsp:useBean id="client" class="main.webapp.Backend.Banking.Client.Client" scope="session"></jsp:useBean>
    <%
        client = (Client) request.getSession().getAttribute("client");
    %>
    <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<style>
    <%@ include file="/Pages/Styles/baseStyle.css" %>
    <%@ include file="/Pages/Styles/infoStyle.css" %>
</style>
    <div class="container">
        <h1>Information</h1>
        <div class="information-list">
            <div class="information-item">
                Your name is : <%= client.getName() %>
            </div>
            <div class="information-item">
                Your surname is : <%= client.getSurname() %>
            </div>
            <div class="information-item">
                Your phone is : <%= client.getPhone() %>
            </div>
            <div class="information-item">
                Your gender is : <%= client.getGender() %>
            </div>
            <div class="information-item">
                Your birthdate is : <%= client.getBirthdate() %>
            </div>
            <div class="information-item">
                Your age is : <%= client.getAge() %>
            </div>
            <div class="information-item">
                Your card number is : <%= client.getCardNum() %>
            </div>
            <div class="information-item">
                Your balance is : <%= client.getCard().getValue() %>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/main">
            <button type="submit">Go to main</button>
        </form>
    </div>
</body>
</html>
