<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Форма регистрации посетителей</title>
</head>
<body>
<h1>Регистрация посетителей</h1>
<form action="AddUser" method="post">
    Пользователь (nickname): <input type="text" name="user" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    ФИО: <input type="text" name="fio"><br>
    email: <input type="text" name="email"><br>
    Телефон: <input type="text" name="phone"><br>
    <p>
    <table>
        <tr>
            <th>
                <small>
                    <input type="submit" name="save" value="Сохранить">
                </small>
            <th>
                <small>
                    <input type="submit" name="cancel" value="Выйти">
                </small>
    </table>
</form>
</body>
</html>
