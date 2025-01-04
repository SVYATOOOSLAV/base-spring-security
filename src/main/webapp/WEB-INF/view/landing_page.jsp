<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Landing page</title>
</head>
<body>

<h3>Welcome to the Company Portal</h3>

<br>
<input type="button" value="Employees"
       onclick="window.location.href = 'employees_info'">
Only for employees

<br><br>
<input type="button" value="Сменить пользователя"
       onclick="window.location.href = 'login'">


</body>
</html>
