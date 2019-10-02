<%@include file="/Pages/Blocks/Head.jsp" %>
<body>
<style>
    <%@ include file="/Pages/Styles/baseStyle.css" %>
    <%@ include file="/Pages/Styles/admin.css" %>
</style>
<div class="container">
    <h1>Change card number</h1>

    <form action="${pageContext.request.contextPath}/setCardNum" method="post">
        <div class="input-field">
            <label for="oldCardNum">Enter old card num :</label>
            <input type="text" name="oldCardNum" id="oldCardNum">
        </div>
        <div class="input-field">
            <label for="newCardNum">Enter new card num :</label>
            <input type="text" name="newCardNum" id="newCardNum">
        </div>
        <button type="submit">Set new card number</button>
    </form>

    <form action="${pageContext.request.contextPath}/admin" method="get">
        <button type="submit">To admin panel</button>
    </form>
</div>
</body>
</html>
