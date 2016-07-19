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
	您现在的位置：<a href="/news.do">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach var="cart" items="${cart.items}">
				<tr id="product_id_1">
					<td class="thumb"><img src="images/product/${cart.product.ep_picture}.jpg" style="height:20px; width:20px"/><a href="selling.do?id=${cart.product.ep_id}&action=detil&flag=detil">${cart.product.ep_name}</a></td>
					<td class="price" id="price_id_1">
						<span>￥${cart.cost}</span>
						<input type="hidden" value="${cart.cost}" />
					</td>
					<td class="number">
						<dl>
							<form action="buy.do",method="post">
								<dt><input id="number_id_1" type="text" name="number" value="${cart.quantity}" /></dt>
								<input type="hidden" value="${cart.product.ep_id}" name="id">
								<dd><input type="submit" value="修改"></dd>
							</form>
						</dl>
					</td>
					<td class="delete"><a href="javascript:delShopping(${cart.product.ep_id});">删除</a></td>
				</tr>
				</c:forEach>
			</table>
		<form action="buy.do" method="post">
			<div class="button" name="结算"><input type="hidden" value="pay" name="operation" >
				<input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
