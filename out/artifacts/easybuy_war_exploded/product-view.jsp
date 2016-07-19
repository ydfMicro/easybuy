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
	您现在的位置：<a href="/news.do">易买网</a>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<%@ include file="layout/lefter.jsp" %>
	</div>
	<div id="product" class="main">
				<h1>${pdetil.ep_name}</h1>
				<div class="infos">
					<div class="thumb"><img src="images/product/${pdetil.ep_picture}_max.jpg" /></div>
					<div class="buy">
						<p>商城价：<span class="price">￥${pdetil.ep_price}</span></p>
						<p>库　存：${pdetil.ep_stock}</p>
						<div class="button"><input type="button" name="button" value="" onclick="goBuy(${pdetil.ep_id})" /><a href="buy.do?id=${pdetil.ep_id}&operation=add">放入购物车</a></div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="introduce">
					<h2><strong>商品详情</strong></h2>
					<div class="text">
						${pdetil.ep_description}<br />
						<br />
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
