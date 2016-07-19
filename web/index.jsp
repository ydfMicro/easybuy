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
<div id="main" class="wrap">
	<div class="lefter">
		<%@ include file="layout/lefter.jsp" %>
		<div class="spacer"></div>
		<%@ include file="layout/recent.jsp" %>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
				<c:forEach var="disco" items="${discoList}">
					<li>
						<dl>
							<dt><a href="/selling.do?id=${disco.ep_id}&flag=detil" target="_blank"><img src="images/product/${disco.ep_picture}.jpg" /></a></dt>
							<dd class="title"><a href="/selling.do?id=${disco.ep_id}&flag=detil" target="_blank">${disco.ep_name}</a></dd>
							<dd class="price">￥${disco.ep_price}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="side">
			<%@ include file="layout/righter.jsp" %>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<c:forEach var="selling" items="${sellingList}">
					<li>
						<dl>
							<dt><a href="/selling.do?id=${selling.ep_id}&flag=detil" target="_blank"><img src="images/product/${selling.ep_picture}.jpg" /></a></dt>
							<dd class="title"><a href="/selling.do?id=${selling.ep_id}&flag=detil" target="_blank">${selling.ep_name}</a></dd>
							<dd class="price">￥${selling.ep_price}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
