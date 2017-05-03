<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>Форма входа в систему</title>
</head>
<body>
<br>
<h1>Вход в систему</h1>
<form action="/CheckUsers.java/" method="post">
    Пользователь: <input type="text" name="user" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    <p>
    <table>
        <tr>
            <th>
                <small>
                    <input type="submit" name="login" value="Войти в систему">
                </small>
            <th>
                <small>
    <tr>
        <td colspan="2">Для регистрации щелкните <a href="registration.jsp">здесь</a></td>
    </tr>

                </small>
    </table>
</form>
<br>
</body>
</html>