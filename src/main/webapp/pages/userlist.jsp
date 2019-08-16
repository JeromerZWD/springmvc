<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/7
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
<table>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="">修改</a>
                <a href="">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</form>

</body>
</html>
