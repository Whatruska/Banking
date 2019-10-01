<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="/Pages/Blocks/Head.jsp" %>
<body>
<style>
    <%@ include file="/Pages/Styles/baseStyle.css" %>
</style>
<div class="container">
    <h1>Transaction</h1>
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
    <form action="${pageContext.request.contextPath}/main" method="get">
        <button type="submit">To main panel</button>
    </form>
</div>
</body>
</html>
