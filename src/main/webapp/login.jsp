<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>Форма входа в систему</title>
</head>
<body>
<br>
<h1>Добро пожаловать в ИС Добавление статей!</h1>

<form action="/login" method="post">
    Пользователь: <input type="text" name="user" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    <p>
    <table>
        <tr>
                <small>
                    <input type="submit" name="login" value="Войти в систему">
                </small>



        </tr>

        <tr>
            <small>
                <td><input type="button" value="Регистрация" onclick="location.href = '<%= request.getContextPath() %>/Registration'"></td>
            </small>
           <%-- <td colspan="2">Для регистрации щелкните <a href="registration.jsp">здесь</a></td>
            <td><input type="button" value="Регистрация" onclick="location.href = '<%= request.getContextPath() %>/Registration'"></td>--%>
        </tr>
    </table>
</form>

<tr>
   <%-- <td colspan="2">Просмотр общедоступных статей <a href="error.jsp">View Publication</a></td>--%>
    <td><input type="button" value="Просмотр общедоступных статей" onclick="location.href = '<%= request.getContextPath() %>/freepublic'"></td>

</tr>
<br>
</body>
</html>