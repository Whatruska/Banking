<html>
<%@include file="/Pages/Blocks/Head.jsp" %>
<body>
<style>
    <%@ include file="/Pages/Styles/baseStyle.css" %>
    <%@ include file="/Pages/Styles/admin.css" %>
</style>
<div class="container">
    <h1>Give a free money</h1>

    <form action="${pageContext.request.contextPath}/setBalance" method="post">
        <div class="input-field">
            <label for="cardNum">Enter card num to set balance</label>
            <input type="number" name="cardNum" id="cardNum">
        </div>
        <div class="input-field">
            <label for="value">Enter new value :</label>
            <input type="number" name="value" id="value">
        </div>
        <button type="submit">Set new balance to card</button>
    </form>

    <form action="${pageContext.request.contextPath}/admin" method="get">
        <button type="submit">To admin panel</button>
    </form>
</div>
</body>
</html>
