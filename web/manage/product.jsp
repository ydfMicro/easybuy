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
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				<c:forEach var="p" items="${PproductList}">
					<tr>
						<td class="first w4 c">${p.ep_id}</td>
						<td class="thumb"><img src="/images/product/${p.ep_picture}.jpg" style="height:20px; width:20px"/><a href="/selling.do?id=${p.ep_id}&flag=detil" target="_blank">${p.ep_name}</a></td>
						<td class="w1 c"><a href="/manage/product-modify.jsp?name=${p.ep_name}&id=${p.ep_id}">修改</a> <a href="javascript:DeleteProduct(${p.ep_id} );">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${PpageIndex>1}">
						<li><a href="mpro.do?PpageIndex=${PpageIndex-1}">上一页</a></li>
					</c:if>
					<li class="current"></li>
					<c:forEach var="p" begin="1" end="${PtotalPage}">
						<li><a href="mpro.do?PpageIndex=${p}&flag=view">${p}</a></li>
					</c:forEach>
					<c:if test="${PpageIndex<PtotalPage}">
						<li><a href="mpro.do?PpageIndex=${PpageIndex+1}">下一页</a></li>
					</c:if>
				</ul>
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
