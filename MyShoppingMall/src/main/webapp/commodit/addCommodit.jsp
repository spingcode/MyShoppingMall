<%--
  Created by IntelliJ IDEA.
  User: zouw
  Date: 2018/2/23
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
        <form action="${pageContext.request.contextPath}/public/commodit/addCommodit" method="post">
            商品名称：<input type="text" name="title"><br/>
            商品价格：<input type="text" name="price"><br/>
            商品图片：<input type="text" name="commoditImg"><br/>
            商品摘要：<input type="text" name="commoditAbstract"><br/>
            商品正文：<input type="text" name="commoditText"><br/>
            商品数量：<input type="text" name="number"><br/>
            <input type="submit" value="提交">
        </form>
</body>
</html>
