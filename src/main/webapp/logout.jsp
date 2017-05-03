<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03.05.2017
  Time: 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.setAttribute("userLogin", null);
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/");
%>
