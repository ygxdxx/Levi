<%--
  Created by IntelliJ IDEA.
  User: Cortana
  Date: 2017/6/7
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}+/RegisterServlet" method="post">
        <span>用户名：</span><input type="text" name="username">
        <span>用户名</span><input type="text" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>