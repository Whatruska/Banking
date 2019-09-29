<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
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
