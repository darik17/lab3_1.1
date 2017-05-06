<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>User Pages</title>
</head>
<body>
<a href='logout.jsp'>Log out</a>
<h1>
    <%=session.getAttribute("login")%>
</h1>

</body>
</html>
