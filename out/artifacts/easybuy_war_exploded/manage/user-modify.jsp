<%@ page import="sdkd.com.ec.model.EYUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
		<h2>修改用户</h2>
		<div class="manage">
			<form action="/modifyuser.do?action=update" method="post">
				<table class="form">
					<input type="hidden" class="text" name="id" value="<%= new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"utf-8")%>" />
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="userName" value="<%= new String(request.getParameter("user_name").getBytes("ISO-8859-1"),"utf-8")%>"  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="passWord" value="<%= new String(request.getParameter("user_password").getBytes("ISO-8859-1"),"utf-8")%>"  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">身份证号：</td>
						<td><input type="text" class="text" name="identity_code" value="<%= new String(request.getParameter("user_identity").getBytes("ISO-8859-1"),"utf-8")%>"  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email" value="<%= new String(request.getParameter("user_email").getBytes("ISO-8859-1"),"utf-8")%>" style="width:150px" />
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value="<%= new String(request.getParameter("user_mobile").getBytes("ISO-8859-1"),"utf-8")%>"  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" value="<%= new String(request.getParameter("user_address").getBytes("ISO-8859-1"),"utf-8")%>"  style="width:150px" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
