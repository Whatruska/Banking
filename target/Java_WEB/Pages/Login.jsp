<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
    <%@include file="/Pages/Blocks/Head.jsp" %>
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
