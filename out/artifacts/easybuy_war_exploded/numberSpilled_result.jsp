<%--
  Created by IntelliJ IDEA.
  User: ydf_m
  Date: 2016/7/11
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@ include file="layout/top.jsp" %>
<div id="register" class="wrap">
    <div class="shadow">
        <em class="corner lb"></em>
        <em class="corner rt"></em>
        <div class="box">
            <%--<ul class="steps clearfix">--%>
            <%--<li class="finished"><em></em>填写注册信息</li>--%>
            <%--<li class="last-current"><em></em>注册成功</li>--%>
            <%--</ul>--%>
            <div class="msg">
                <p>对不起，你要购买的商品库存不足！！</p>
                <p>正在为你跳回首页.....</p>
                <script type="text/javascript">
                    setTimeout("location.href='/news.do'", 3000);
                </script>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

