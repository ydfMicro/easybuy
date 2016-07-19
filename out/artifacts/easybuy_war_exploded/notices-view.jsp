<%--
  Created by IntelliJ IDEA.
  User: ydf_m
  Date: 2016/7/9
  Time: 9:10
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
<div id="position" class="wrap">
    您现在的位置：<a href="/news.do">易买网</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
    <div class="left-side">
        <div class="news-list">
            <h4>最新公告</h4>
            <ul>
                <c:forEach var="notices" items="${noticesList}">
                    <li><a href="notice.do?id=${notices.en_id}&action=detil" target="_blank">${notices.en_title}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="spacer"></div>
        <div class="news-list">
            <h4>新闻动态</h4>
            <ul>
                <c:forEach var="news" items="${newList}">
                    <li><a href="news.do?id=${news.en_id}&action=detil" target="_blank">${news.en_title}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div id="news" class="right-main">
        <h1>${notice.en_title}</h1>
        <div class="content">
            ${notice.en_content}
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
