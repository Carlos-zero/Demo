<%--
  Created by IntelliJ IDEA.
  User: 94801
  Date: 2019/2/10
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆界面</title></head>
<body>
<form action="/servlet/LoginServlet/" method="post">
    帐号:<input type="text" name="telephone"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>

</html>
