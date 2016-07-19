<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	您现在的位置：<a href="/news.do">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<%@ include file="layout/lefter.jsp" %>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				<c:forEach var="comment" items="${commentList}">
					<li>${comment.ec_content}  网友:  ${comment.ec_nick_name} 日期： ${comment.ec_create_time}</li>

					<li>${comment.ec_reply}</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="/com.do?pageIndex=1">首页</a></li>
					<c:if test="${pageIndex>1}"><li><a href="/com.do?pageIndex=${pageIndex-1}">上一页</a></li></c:if>
					<c:forEach var="page" begin="1" end="${totalPage}">
						<li><a href="/com.do?pageIndex=${page}">${page}</a></li>
					</c:forEach>
					<c:if test="${pageIndex<totalPage}"><li><a href="/com.do?pageIndex=${pageIndex+1}">下一页</a></li></c:if>
				</ul>
			</div>
			<div id="reply-box">
				<form>
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" /></td>
						</tr>
						<tr>
							<td class="field">留言标题：</td>
							<td><input class="text" type="text" name="guestTitle" /></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
	<div id="footer">
		Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
	</div>
</body>
</html>
