<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>
    <%@include file="/Pages/Blocks/Head.jsp" %>
<body>
    <style>
        <%@ include file="/Pages/Styles/baseStyle.css" %>
    </style>
    <div class="container">
        <h1>Register</h1>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="input-field">
                <label for="name">Your name :</label>
                <input type="text" id="name" name="name" required="required">
            </div>

            <div class="input-field">
                <label for="surname">Your surname :</label>
                <input type="text" id="surname" name="surname" required="required">
            </div>

            <div class="input-field">
                <label for="birthdate">Your birthdate :</label>
                <input type="date" id="birthdate" name="birthdate" required="required">
            </div>

            <div class="input-field">
                <input type="radio" name="gender" required="required" value="MALE"><span>Male</span>
                <input type="radio" name="gender" required="required" value="FEMALE"><span>Female</span>
            </div>

            <div class="input-field">
                <label for="phone">Your phone :</label>
                <input type="tel" id="phone" placeholder="+12345678901" name="phone" required="required">
            </div>

            <div class="input-field">
                <label for="password">Your password :</label>
                <input type="password" id="password" name="password" required="required">
            </div>

            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
