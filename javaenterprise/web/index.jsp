<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 11.06.2020
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>JSP Sample</title>
</head>
<body>
<p>This is Java EE App! Hi, <%= request.getRemoteHost() %></p>
<p>This is Java EE App! Hi, <%= request.getRemoteUser()%></p>

</body>
</html>
