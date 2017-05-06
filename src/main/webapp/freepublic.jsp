<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05.05.2017
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page errorPage="error.jsp" %>--%>
<html>
<head>
    <title>Все публикации</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <th>public_ID</th>
        <th>name_publicat</th>
        <th>tag</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.freepublic}" var="freepublic">
        <tr>
            <td><c:out value="${freepublic.publication_id}"></c:out></td>
            <td><c:out value="${freepublic.name_publication}"></c:out></td>
            <td><c:out value="${freepublic.tag}"></c:out></td>
            <td><input type="button" value="Читать полностью" onclick="location.href = '<%= request.getContextPath() %>/viewpublic?publication_id=<c:out value="${freepublic.publication_id}" />'"></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
