<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
</head>

<body>
<div class="top">
    <div  class="top_login">卖家您好，${sellerUser}&nbsp;<a href="${pageContext.request.contextPath}/public/user/exit" class="top_a">[退出]</a></div>
    <div  class="top_first"><a href="${pageContext.request.contextPath}/" class="top_a">首页</a>&nbsp;|&nbsp;<a href="#" class="top_a">发布</a></div>
</div>
<div class="center">
    <div class="container">
        <h2 class="context"><a href="${pageContext.request.contextPath}/">所有内容</a></h2>
        <c:choose>
            <c:when test="${not empty result.value}">
                <c:forEach var="commodit" items="${result.value}" varStatus="vs">
                    <div class="per">
                        <a href="${pageContext.request.contextPath}/public/commodit/showCommoditByCommodiyId?commoditId=${commodit.commoditId}">
                            <div class="image"><img src="${pageContext.request.contextPath}/img/${commodit.commoditImg}" alt="图片${vs.count}"/></div>
                            <div class="title">${commodit.title}</div>
                            <h3>¥<span class="price">${commodit.price}</span></h3>
                        </a>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="3">对不起，没有你要找的数据</td>
                </tr>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<div class="foot">
    备注说明：网易考拉应届生作业
</div>
</body>
</html>