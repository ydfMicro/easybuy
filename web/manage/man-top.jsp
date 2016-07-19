<%--
  Created by IntelliJ IDEA.
  User: ydf_m
  Date: 2016/7/13
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="../images/logo.gif" /></div>
    <div class="help"><a href="../news.do">返回前台页面</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li class="current"><a href="index.jsp">首页</a></li>
            <li><a href="/modifyuser.do?action=get">用户</a></li>
            <li><a href="product.jsp">商品</a></li>
            <li><a href="order.jsp">订单</a></li>
            <li><a href="guestbook.jsp">留言</a></li>
            <li><a href="/modifynews.do?action=get">新闻</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="welcome wrap">
        管理员pillys您好，今天是
        <script type="text/javascript">
            var a_names=new Array("01","02","03","04","05","06","07","08","09","10","11","12")
            var currentTime=new Date()
            var year=currentTime.getFullYear()
            var month=currentTime.getMonth()
            var date=currentTime.getDate()
            document.write(year+"-"+a_names[month]+"-"+date)
        </script>
        ，欢迎回到管理后台。
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>用户管理</dt>
                <dd><em><a href="/manage/user-add.jsp">新增</a></em><a href="/modifyuser.do?action=get">用户管理</a></dd>
                <dt>商品信息</dt>
                <dd><em><a href="/manage/productClass-add.jsp">新增</a></em><a href="/manage/productClass.jsp">分类管理</a></dd>
                <dd><em><a href="/manage/product-add.jsp">新增</a></em><a href="/mpro.do">商品管理</a></dd>
                <dt>订单管理</dt>
                <dd><a href="/morder.do">订单管理</a></dd>
                <dt>留言管理</dt>
                <dd><a href="/manage/guestbook.jsp">留言管理</a></dd>
                <dt>新闻管理</dt>
                <dd><em><a href="/manage/news-add.jsp">新增</a></em><a href="/modifynews.do?action=get">新闻管理</a></dd>
            </dl>
        </div>
    </div>
</div>
</body>
</html>
