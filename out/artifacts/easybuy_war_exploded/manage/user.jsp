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
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>用户名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${getuser}">
					<tr>
						<td class="first w4 c">${user.eu_user_id}</td>
						<td class="w1 c">${user.eu_user_name}</td>
						<td class="w2 c">${user.eu_sex}</td>
						<td>${user.eu_mail}</td>
						<td class="w4 c">${user.eu_mobile}</td>
						<td class="w1 c"><a href="/manage/user-modify.jsp?user_id=${user.eu_user_id}&user_name=${user.eu_user_name}&user_password=${user.eu_password}&user_identity=${user.eu_identity_code}&user_email=${user.eu_mail}&user_mobile=${user.eu_mobile}&user_address=${user.eu_address}">修改</a>
							<a href="javascript:DeleteUser(${user.eu_user_id});">删除</a></td>
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
