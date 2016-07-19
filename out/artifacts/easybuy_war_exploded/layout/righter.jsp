<%--
  Created by IntelliJ IDEA.
  User: ydf_m
  Date: 2016/7/12
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
</body>
</html>
