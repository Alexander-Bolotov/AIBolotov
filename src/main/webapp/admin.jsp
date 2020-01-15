<%@ page import="service.Service" %>
<%@ page import="service.ServiceIml" %>
<% Service service = ServiceIml.getInstance();
%>
<% HttpSession session1 = request.getSession();%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<p>Сессия: name = <%= session1.getAttribute("name")%>
    password = <%=session1.getAttribute("password")%>
    role = <%=session1.getAttribute("role")%>
</p>
<p><a href="${pageContext.request.contextPath}/admin.jsp">Перейти на admin.jsp</a></p>
<p><a href="${pageContext.request.contextPath}/user.jsp">Перейти на user.jsp</a></p>
<p>Привет, <%=session1.getAttribute("name")%></p>
<a href="${pageContext.request.contextPath}/logout">Разлогиниться</a>

<hr/>
<p> Добавить User-a в БД
    <%--    <a href="registration.html">Добавить пользователя</a>--%>
    <form action="${pageContext.request.contextPath}/registration" method="POST">
        Name: <input type="text" name="name"/>
<p>
    Password: <input type="password" name="password"/>
<p>
    <input type="submit" value="Добавить">
    </form>
<hr/>
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
