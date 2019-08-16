<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/4
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table bgcolor="#dc143c" border="1">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>密码</td>
    </tr>
<c:forEach items="${list}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
