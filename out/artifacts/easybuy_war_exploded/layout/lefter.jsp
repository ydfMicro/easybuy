<%--
  Created by IntelliJ IDEA.
  User: ydf_m
  Date: 2016/7/7
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="box">
    <h2>商品分类</h2>
    <dl>
        <c:forEach var="ca" items="${category}">
            <c:if test="${ca.epc_parent_id==0}">
                <dt>${ca.epc_name}</dt>
            </c:if>
            <c:forEach var="pca" items="${category}">
                <c:if test="${ca.epc_id==pca.epc_parent_id}">
                    <dd><a href="/pro.do?action=list&parent_id=${pca.epc_parent_id}&type_id=${pca.epc_type_id}">${pca.epc_name}</a></dd>
                </c:if>
            </c:forEach>
        </c:forEach>
    </dl>
</div>
</body>
</html>
