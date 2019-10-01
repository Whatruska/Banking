<html>
    <%@include file="/Pages/Blocks/Head.jsp" %>
<body>
    <style>
        <%@ include file="/Pages/Styles/baseStyle.css" %>
        <%@ include file="/Pages/Styles/admin.css" %>
    </style>
    <div class="container">
        <h1>Delete user</h1>

        <form action="${pageContext.request.contextPath}/delete" method="post">
            <div class="input-field">
                <label for="phone">Enter phone to delete :</label>
                <input type="tel" name="phone" id="phone">
            </div>
            <button type="submit">Delete user</button>
        </form>

        <form action="${pageContext.request.contextPath}/admin" method="get">
            <button type="submit">To admin panel</button>
        </form>
    </div>
</body>
</html>
