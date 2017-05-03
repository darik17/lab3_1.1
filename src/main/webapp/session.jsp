<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 02.05.2017
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session.setAttribute("userLogin", null);
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/");
%>
