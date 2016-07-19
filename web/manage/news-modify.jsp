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
		<h2>修改新闻</h2>
		<div class="manage">
			<form action="/modifynews.do?action=update" method="post">
				<table class="form">
					<input type="hidden" class="text" name="id" value="<%= new String(request.getParameter("news_id").getBytes("ISO-8859-1"),"utf-8")%>"/>
					<tr>
						<td class="field">新闻标题：</td>
						<td><input type="text" class="text" name="title" value="<%= new String(request.getParameter("news_title").getBytes("ISO-8859-1"),"utf-8")%>" /></td>
					</tr>
					<tr>
						<td class="field">新闻内容：</td>
						<td><textarea name="content"><% new String(request.getParameter("news_content").getBytes("ISO-8859-1"),"utf-8"); %></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
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
