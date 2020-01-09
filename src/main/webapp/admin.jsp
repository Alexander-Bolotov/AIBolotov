<%@ page import="src.main.service.Service" %>
<% Service service = Service.getInstance();
%>
<% HttpSession session1 = request.getSession();%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<p>Привет, <%=session1.getAttribute("name")%></p>
<a href="${pageContext.request.contextPath}/logout">Разлогиниться</a>
<hr/>
<form action="${pageContext.request.contextPath}/registration" method="POST">
    <p>
        New Name: <input type="text" name="name"/>
    <p>
        New Password: <input type="text" name="password"/>
    <p>
        Role: <input type="text" name="role"/>
    <p>
        <input type="submit" value="Зарегистрировать!">
</form>

<hr/>
<form action="${pageContext.request.contextPath}/edit" method="POST">
    <p>
        ID: <input type="text" name="id"/>
    <p>
        New Name: <input type="text" name="name"/>
    <p>
        New Password: <input type="text" name="password"/>
    <p>
        <input type="submit" value="Изменить">
</form>
<hr/>
<p> Пользователи <%= service.getAllUsers().toString() %>
</body>
</html>
