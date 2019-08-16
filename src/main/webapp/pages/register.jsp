<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/5
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/testpojo" method="post">
id:<input type="text" name="id"><br>
    username:<input type="text" name="username"><br>
    password:<input type="text" name="password"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
