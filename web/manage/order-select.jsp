<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理 - 易买网</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="/manage/man-top.jsp" %>
<div class="main">
    <h2>订单管理</h2>
    <div class="manage">
        <div class="search">
            <form action="/morder.do?flag2=select" method="post">
                订单号：<input type="text" class="text" name="orderId" /> 订货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
            </form>
        </div>
        <div class="spacer"></div>
        <table class="list">
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>发货地址</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <c:forEach var="order" items="${orderlist}">
                <tr>
                    <td class="first w4 c">${order.eo_id}</td>
                    <td class="w1 c">${order.eo_user_name}</td>
                    <td>${order.eo_user_address}</td>
                    <td class="w1 c">${order.eo_status}</td>
                    <td class="w1 c"><a href="/manage/order-modify.jsp?id=${order.eo_id}">修改</a> <a href="javascript:DeleteOrder(${order.eo_id});">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
