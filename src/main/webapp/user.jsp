<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% HttpSession session1 = request.getSession();%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    Привет,    <%=session1.getAttribute("name")%>>!

</p>
<p><a href="${pageContext.request.contextPath}/logout">Разлогиниться</a></p>
</body>
</html>
