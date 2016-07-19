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
	您现在的位置：<a href="/news.do">易买网</a> &gt; 图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<%@ include file="layout/lefter.jsp" %>
		</div>
		<div class="spacer"></div>
		<%@ include file="layout/recent.jsp" %>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
						<li><a href="/pro.do?action=list&pageIndex=1&parent_id=${parent_id}&type_id=${type_id}">首页</a></li>
						<c:if test="${pageIndex>1}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex-1}&parent_id=${parent_id}&type_id=${type_id}">上一页</a></li></c:if>
					<c:forEach var="page" begin="1" end="${totalPage}">
						<li><a href="/pro.do?action=list&pageIndex=${page}&parent_id=${parent_id}&type_id=${type_id}">${page}</a></li>
					</c:forEach>
						<c:if test="${pageIndex<totalPage}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex+1}&parent_id=${parent_id}&type_id=${type_id}">下一页</a></li></c:if>
						<li><a href="/pro.do?action=list&pageIndex=${totalPage}&parent_id=${parent_id}&type_id=${type_id}">尾页</a></li>
					<input type="text" style="width:25px" id="toPage" /> <button onclick="goPage(${parent_id},${type_id}, ${totalPage})">go</button>
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
				<c:forEach var="pro" items="${productList}">
					<li>
						<dl>
							<dt><a href="/selling.do?id=${pro.ep_id}&flag=detil" target="_blank"><img src="images/product/${pro.ep_picture}_max.jpg" /></a></dt>
							<dd class="title"><a href="/selling.do?id=${pro.ep_id}&flag=detil" target="_blank">${pro.ep_name}</a></dd>
							<dd class="price">￥${pro.ep_price}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="/pro.do?action=list&pageIndex=1&parent_id=${parent_id}&type_id=${type_id}">首页</a></li>
					<c:if test="${pageIndex>1}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex-1}&parent_id=${parent_id}&type_id=${type_id}">上一页</a></li></c:if>
					<c:forEach var="page" begin="1" end="${totalPage}">
						<li><a href="/pro.do?action=list&pageIndex=${page}&parent_id=${parent_id}&type_id=${type_id}">${page}</a></li>
					</c:forEach>
					<c:if test="${pageIndex<totalPage}"><li><a href="/pro.do?action=list&pageIndex=${pageIndex+1}&parent_id=${parent_id}&type_id=${type_id}">下一页</a></li></c:if>
					<li><a href="/pro.do?action=list&pageIndex=${totalPage}&parent_id=${parent_id}&type_id=${type_id}">尾页</a></li>
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
