<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/5
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" >
    <input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
