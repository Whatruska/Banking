<html>
    <%@include file="/Pages/Blocks/Head.jsp" %>
<body>
    <style>
        <%@ include file="/Pages/Styles/baseStyle.css" %>
        <%@ include file="/Pages/Styles/admin.css" %>
    </style>
    <div class="container">
        <h1>Admin panel</h1>

        <form action="${pageContext.request.contextPath}/delete" method="get">
            <button type="submit">Delete user</button>
        </form>

        <form action="${pageContext.request.contextPath}/giveAdmin" method="get">
            <button type="submit">Give admin access</button>
        </form>

        <form action="${pageContext.request.contextPath}/removeAdmin" method="get">
            <button type="submit">Remove admin</button>
        </form>

        <form action="${pageContext.request.contextPath}/setBalance" method="get">
            <button type="submit">Set Balance</button>
        </form>

        <form action="${pageContext.request.contextPath}/setCardNum" method="get">
            <button type="submit">Set Card num</button>
        </form>

        <form action="${pageContext.request.contextPath}/sql" method="get">
            <button type="submit">Execute sql</button>
        </form>

        <form action="${pageContext.request.contextPath}/main" method="get">
            <button type="submit">To main panel</button>
        </form>

    </div>
</body>
</html>
