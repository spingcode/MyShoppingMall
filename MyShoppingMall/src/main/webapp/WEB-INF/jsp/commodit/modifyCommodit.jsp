<%--
  Created by IntelliJ IDEA.
  User: zouw
  Date: 2018/2/23
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑商品</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/public/commodit/updateCommodit" method="post">
        商品名称：<input type="text" name="title" value="${result.value.title}"><br/>
        商品价格：<input type="text" name="price" value="${result.value.price}"><br/>
        商品图片：<input type="text" name="commoditImg" value="${result.value.commoditImg}"><br/>
        商品摘要：<input type="text" name="commoditAbstract" value="${result.value.commoditAbstract}"><br/>
        商品正文：<input type="text" name="commoditText" value="${result.value.commoditText}"><br/>
        商品数量：<input type="text" name="number" value="${result.value.number}"><br/>
        <input type="hidden" name="commoditId" value="${result.value.commoditId}">
        <input type="submit" value="提交">
    </form>
</body>
</html>
