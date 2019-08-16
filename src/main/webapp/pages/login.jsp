<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/5
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="${pageContext.request.contextPath }/login" method="post">
username:<input type="text" name="username" /><br>
password:<input type="text" name="password" /><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
