<%--
  Created by IntelliJ IDEA.
  User: zouw
  Date: 2018/2/26
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/login.css">
    <script>
        function login()
        {
            var userName = document.getElementById("userName").value;
            var password = document.getElementById("password").value;
            alert("pa:"+password)
            if ((userName.trim()==""||userName==null)||(password.trim()==""||password==null))
            {
                alert("用户名或者密码为空"+password);
            }
            else {
                document.getElementById("form1").submit();
            }
        }
    </script>
</head>
<body>
    <div class="top">
        <div  class="top_login">请<a href="${pageContext.request.contextPath}/login.jsp" class="top_a">[登录]</a></div>
        <div  class="top_first"><a href="${pageContext.request.contextPath}/" class="top_a">首页</a></div>
    </div>

    <div class="login">
        <form action="${pageContext.request.contextPath}/public/user/login" method="post" id="form1">
            <div class="ele">用户名：<input type="text" name="userName" id="userName"></div><br>
            <div class="ele">密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password" ></div><br>
            <div class="ele"><input onclick="login()" type="button" value="登录" class="submit"/></div>
        </form>
    </div>
    <div class="foot">
        备注说明：网易考拉应届生作业
    </div>
</body>
</html>
