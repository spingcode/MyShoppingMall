<%--
  Created by IntelliJ IDEA.
  User: zouw
  Date: 2018/1/28
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>内容销售系统</title>
</head>
<body>
<table align="center" cellspacing="10">
    <caption>销售的内容<br/>
    </caption>
    <tr>
        <th align="center">
            序号
        </th>
        <th align="center">
            商品名称
        </th>
        <th align="center">
            商品图片
        </th>
        <th align="center">
            商品价格
        </th>
        <th align="center">
            商品摘要
        </th>
        <th align="center">
            商品正文
        </th>
        <th align="center">
            商品数量
        </th>
    </tr>
    <c:choose>
        <c:when test="${not empty result.value}">
            <c:forEach var="commodit" items="${result.value.context}" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${commodit.title}</td>
                    <td>${commodit.commoditImg}</td>
                    <td>${commodit.price}</td>
                    <td>${commodit.commoditAbstract}</td>
                    <td>${commodit.commoditText}</td>
                    <td>${commodit.number}</td>
                    <td><<a href="${pageContext.request.contextPath}/public/commodit/deleteCommodit?commoditId=${commodit.commoditId}">删除</a>></td>
                    <td><<a href="${pageContext.request.contextPath}/public/commodit/modifyCommodit?commoditId=${commodit.commoditId}">更新</a>></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="3">对不起，没有你要找的数据</td>
            </tr>
        </c:otherwise>
    </c:choose>
    <tr>
        <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/public/commodit/getAllCommodit?pageNum=${result.value.beforePage}&pageSize=10">上一页</a></td>
        <td>第${result.value.pageNum}页</td>
        <td><a href="${pageContext.request.contextPath}/public/commodit/getAllCommodit?pageNum=${result.value.afterPage}&pageSize=10">下一页</a></td>
        <td>共${result.value.maxPage}页</td>
    </tr>
    <tr>
        <td colspan="3" align="center"><a href="${pageContext.request.contextPath}/commodit/addCommodit.jsp">添加商品</a></td>
    </tr>
</table>
</body>
</html>
