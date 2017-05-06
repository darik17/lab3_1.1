<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05.05.2017
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Публикация</title>
</head>
<body>

<% String publication = (String) request.getAttribute("text");%>
<% String name = (String) request.getAttribute("name");%>

<h2>
    <%=name%>
</h2>

<h4>
    <%=publication%>
</h4>

</body>
</html>
