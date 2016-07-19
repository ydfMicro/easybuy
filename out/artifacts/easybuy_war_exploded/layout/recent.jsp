<%--
  Created by IntelliJ IDEA.
  User: ydf_m
  Date: 2016/7/12
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="last-view">
    <h2>最近浏览</h2>
    <dl class="clearfix">
        <c:forEach var="recent" items="${recent}">
            <dt><img src="images/product/${recent.ep_picture}.jpg" style="height:50px; width:50px"/></dt>
            <dd><a href="/selling.do?id=${recent.ep_id}&flag=detil">${recent.ep_name}</a></dd>
        </c:forEach>
    </dl>
</div>
</body>
</html>
