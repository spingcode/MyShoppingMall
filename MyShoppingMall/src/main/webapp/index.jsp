<%--
  Created by IntelliJ IDEA.
  User: zouw
  Date: 2018/1/31
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物网站</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/public/seller/registerSeller" method="post">
        账号：<input type="text" name="sellerAccount">
        密码：<input type="text" name="sellerPassword">
        手机号：<input type="text" name="sellerMobile">
        <input type="submit" value="注册卖家">
    </form>

</body>
</html>
