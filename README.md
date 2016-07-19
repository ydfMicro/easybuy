#EBS项目开发
------
通过使用idea、mysql、navicat等工具，使用java+jsp+js+mysql技术来开发一套网上购买商品的网站。


##目录
> * 登录
> * 注册
> * 商品分类
> * 最新公告
> * 新闻动态
> * 商品详情
> * 今日特价
> * 热卖推荐
> * 最近浏览
> * 留言
> * 购物车和结算
> * 用户管理
> * 新闻管理
> * 商品管理
> * 订单管理


##1.登陆

###View

POST方式

**URL:**
http://localhost:8080/login.jsp

**参数:**
<table>
<tr>
	<td>参数</td>
	<td>说明</td>
	<td>示例</td>
</tr>
<tr>
	<td>userName</td>
	<td>登录名</td>
	<td>张三</td>
</tr>
<tr>
	<td>passWord</td>
	<td>密码</td>
	<td>1234</td>
</tr>
<tr>
	<td>veryCode</td>
	<td>验证码</td>
	<td>1258</td>
</tr>
</table>

###Controller

**请求参数:**
<table>
<tr>
	<td>参数</td>
	<td>说明</td>
	<td>示例</td>
</tr>
<tr>
	<td>userName</td>
	<td>从表单获取的用户名</td>
	<td>张三</td>
</tr>
<tr>
	<td>passWord</td>
	<td>从表单获取的密码</td>
	<td>1234</td>
</tr>
</table>

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>list</td>
	<td>EYUser</td>
	<td>从数据库里获取的用户名信息的列表</td>
</tr>
</table>

##2.注册

###View

POST方式

**URL:**
http://localhost:8080/register.jsp

**参数:**
<table>
<tr>
	<td>参数</td>
	<td>说明</td>
	<td>示例</td>
</tr>
<tr>
	<td>userName</td>
	<td>注册的用户名</td>
	<td>tom</td>
</tr>
<tr>
	<td>passWord</td>
	<td>注册密码</td>
	<td>1234</td>
</tr>
<tr>
	<td>rePassWord</td>
	<td>确认密码</td>
	<td>1234</td>
</tr>
<tr>
	<td>veryCode</td>
	<td>验证码</td>
	<td>12306</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>userName</td>
	<td>String</td>
	<td>从表单获取的用户名</td>
</tr>
<tr>
	<td>passWord</td>
	<td>String</td>
	<td>从表单获取的密码</td>
</tr>
</table>

##3.商品分类

###View

**请求参数**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>category</td>
	<td>List</td>
	<td>从servlet中获得的商品分类信息</td>
</tr>
<tr>
	<td>ca</td>
	<td>Category</td>
	<td>循环得到category中的父分类</td>
</tr>
<tr>
	<td>pca</td>
	<td>Category</td>
	<td>循环得到category中的子分类</td>
</tr>
</table>


###Controller

**请求参数**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>list</td>
	<td>List</td>
	<td>从数据库中获得的商品分类信息</td>
</tr>
</table>


##4.最新公告

###View

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>noticesList</td>
	<td>List</td>
	<td>从servlet中获得的公告信息</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
	<td>示例</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>通过request获取的action</td>
	<td>detil</td>
</tr>
<tr>
	<td>list</td>
	<td>List</td>
	<td>从servlet中获得的所有公告标题</td>
	<td></td>
</tr>
<tr>
	<td>n_id</td>
	<td>String</td>
	<td>通过request获取的id（鼠标点击的那条公告）</td>
	<td></td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>将String类型的id转成int类型的</td>
	<td></td>
</tr>
<tr>
	<td>e</td>
	<td>EYNotice</td>
	<td>从数据库中获取对应id公告的详细信息</td>
	<td></td>
</tr>
</table>

**方法:**

<table>
<tr>
	<td>方法名</td>
	<td>返回类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>notices</td>
	<td>void</td>
	<td>获取公告标题</td>
</tr>
<tr>
	<td>NoticesDetil</td>
	<td>void</td>
	<td>获取某id公告的详细信息</td>
</tr>
</table>

##5.新闻动态

###View

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>newList</td>
	<td>List</td>
	<td>从servlet中获得的新闻信息</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
	<td>示例</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>通过request获取的action</td>
	<td>detil</td>
</tr>
<tr>
	<td>list</td>
	<td>List</td>
	<td>从servlet中获得的所有新闻标题</td>
	<td></td>
</tr>
<tr>
	<td>p_id</td>
	<td>String</td>
	<td>通过request获取的id（鼠标点击的那条新闻）</td>
	<td></td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>将String类型的id转成int类型的</td>
	<td></td>
</tr>
<tr>
	<td>e</td>
	<td>EYNews</td>
	<td>从数据库中获取对应id新闻的详细信息</td>
	<td></td>
</tr>
</table>

**方法:**

<table>
<tr>
	<td>方法名</td>
	<td>返回类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>news</td>
	<td>void</td>
	<td>获取新闻标题</td>
</tr>
<tr>
	<td>newsDetil</td>
	<td>void</td>
	<td>获取某id新闻的详细信息</td>
</tr>
</table>

##6.商品详情
###view

**URL:**
http://localhost:8080/product-view.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>pdetil</td>
	<td>EYProduct</td>
	<td>从servlet中获取某件商品的详细信息</td>
</tr>
</table>
###controller

**URL:**
http://localhost:8080/pro.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>根据商品Id获取相应商品</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>根据此标志判定servlet要执行那种操作</td>
</tr>
</table>

##7.今日特价

**URL:**
http://localhost:8080/

###View

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>discoList</td>
	<td>List</td>
	<td>从servlet中获取的今日特价信息</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>discoList</td>
	<td>List</td>
	<td>从数据库中获取的今日特价信息</td>
</tr>
</table>

##8.热卖推荐

**URL:**
http://localhost:8080/

###View

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>sellingList</td>
	<td>List</td>
	<td>从servlet中获取的热卖推荐信息</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>sellingList</td>
	<td>List</td>
	<td>从数据库中获取的热卖推荐信息</td>
</tr>
</table>

##9.最近浏览

###View

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>recent</td>
	<td>List</td>
	<td>从servlet中获取最近浏览信息</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>recentList</td>
	<td>List</td>
	<td>获取的最近浏览信息</td>
</tr>
</table>

##10.留言
**URL:**
http://localhost:8080/com.do

**参数:**
<table>
<tr>
	<td>参数</td>
	<td>说明</td>
	<td>示例</td>
</tr>
<tr>
	<td>guestName</td>
	<td>昵称</td>
	<td>小红</td>
</tr>
<tr>
	<td>guestTitle</td>
	<td>留言标题</td>
	<td>价格</td>
</tr>
<tr>
	<td>guestContent</td>
	<td>留言内容</td>
	<td>最高最低价</td>
</tr>
</table>
###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>commentList</td>
	<td>List</td>
	<td>获取的留言信息</td>
</tr>
</table>

##11.购物车和结算
###添加购买
####view

**URL:**
http://localhost:8080/product-view.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>pdetil.ep_id</td>
	<td>int</td>
	<td>通过获取的商品信息确定要购买的商品Id</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/buy.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>user</td>
	<td>EYLogin</td>
	<td>通过判断user是否为空确定是否登录，进一步决定是否可以将商品放入购物车</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>获取商品Id，确定放入购物车的商品</td>
</tr>
<tr>
	<td>cart</td>
	<td>ShoppingCart</td>
	<td>获取购物车</td>
</tr>
<tr>
	<td>op</td>
	<td>String</td>
	<td>确定执行哪种购物车的操作</td>
</tr>
</table>
###删除购买
####view

**URL:**
http://localhost:8080/shopping.jsp<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>cart</td>
	<td>ShoppingCart</td>
	<td>获取购物车中的商品信息，将其显示在页面中</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/buy.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>op</td>
	<td>String</td>
	<td>确定执行哪种购物车的操作</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>获取商品Id，确定要删除的购物车中的商品</td>
</tr>
<tr>
	<td>cart</td>
	<td>ShoppingCart</td>
	<td>获取购物车中的商品信息</td>
</tr>
</table>
###修改购买数量
####view

**URL:**
http://localhost:8080/shopping.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>cart</td>
	<td>ShoppingCart</td>
	<td>获取购物车中的商品信息，将其显示在页面中</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/buy.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>op</td>
	<td>String</td>
	<td>确定执行哪种购物车的操作</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>获取商品Id，确定要修改的购物车中的商品</td>
</tr>
<tr>
	<td>cart</td>
	<td>ShoppingCart</td>
	<td>获取购物车中的商品信息</td>
</tr>
<tr>
	<td>number</td>
	<td>int</td>
	<td>修改要购买商品的数量</td>
</tr>
</table>
###结算
####view

**URL:**
http://localhost:8080/shopping.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>cart</td>
	<td>ShoppingCart</td>
	<td>获取购物车中的商品信息，将其显示在页面中</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/buy.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>op</td>
	<td>String</td>
	<td>确定执行哪种购物车的操作</td>
</tr>
<tr>
	<td>cart</td>
	<td>ShoppingCart</td>
	<td>获取购物车中的商品信息</td>
</tr>
<tr>
	<td>user</td>
	<td>EYLogin</td>
	<td>获取user的信息，进一步生成订单</td>
</tr>
</table>

##12.用户管理

**URL:**
http://localhost:8080/manage/index.jsp

###新增用户

###View

**参数:**
<table>
<tr>
	<td>参数</td>
	<td>说明</td>
</tr>
<tr>
	<td>userName</td>
	<td>注册的用户名</td>
</tr>
<tr>
	<td>passWord</td>
	<td>注册密码</td>
</tr>
<tr>
	<td>sex</td>
	<td>性别</td>
</tr>
<tr>
	<td>birthyear</td>
	<td>出生年份</td>
</tr>
<tr>
	<td>birthdaymonth</td>
	<td>出生月份</td>
</tr>
<tr>
	<td>birthday</td>
	<td>出生哪一天</td>
</tr>
<tr>
	<td>birthyear</td>
	<td>出生日期</td>
</tr>
<tr>
	<td>identity_code</td>
	<td>身份证号</td>
</tr>
<tr>
	<td>email</td>
	<td>邮箱</td>
</tr>
<tr>
	<td>email_Suffix</td>
	<td>邮箱后缀</td>
</tr>
<tr>
	<td>mobile</td>
	<td>手机号</td>
</tr>
<tr>
	<td>address</td>
	<td>送货地址</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>userName</td>
	<td>String</td>
	<td>从表单获取的用户姓名</td>
</tr>
<tr>
	<td>passWord</td>
	<td>String</td>
	<td>从表单获取的用户密码</td>
</tr>
<tr>
	<td>sex</td>
	<td>String</td>
	<td>从表单获取的用户性别</td>
</tr>
<tr>
	<td>birthday_year</td>
	<td>String</td>
	<td>从表单获取的用户出生年份</td>
</tr>
<tr>
	<td>birthday_month</td>
	<td>String</td>
	<td>从表单获取的用户出生月份</td>
</tr>
<tr>
	<td>birthday_day</td>
	<td>String</td>
	<td>从表单获取的用户出生哪一天</td>
</tr>
<tr>
	<td>birthday</td>
	<td>String</td>
	<td>年月日放在一起</td>
</tr>
<tr>
	<td>identity_code</td>
	<td>String</td>
	<td>从表单获取的用户身份证</td>
</tr>
<tr>
	<td>mail</td>
	<td>String</td>
	<td>从表单获取的用户email</td>
</tr>
<tr>
	<td>mail_suffix</td>
	<td>String</td>
	<td>从表单获取的用户email后缀</td>
</tr>
<tr>
	<td>email</td>
	<td>String</td>
	<td>邮箱和后缀放在一起</td>
</tr>
<tr>
	<td>mobile</td>
	<td>String</td>
	<td>从表单获取的用户手机</td>
</tr>
<tr>
	<td>address</td>
	<td>String</td>
	<td>从表单获取的用户收货地址</td>
</tr>
<tr>
	<td>status</td>
	<td>String</td>
	<td>从表单获取的用户类型</td>
</tr>
<tr>
	<td>userList</td>
	<td>List</td>
	<td>用来存放用户的各个属性</td>
</tr>
</table>

###获取用户

###View

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>/modifyuser.do?action=get</td>
	<td></td>
	<td>调用servlet来获取用户信息</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>userList</td>
	<td>List</td>
	<td>从数据库中获得所有的用户信息</td>
</tr>
</table>

###修改用户

###View

**参数:**

<table>
<tr>
	<td>参数</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>用户id</td>
</tr>
<tr>
	<td>userName</td>
	<td>用户姓名</td>
</tr>
<tr>
	<td>passWord</td>
	<td>用户密码</td>
</tr>
<tr>
	<td>identity_code</td>
	<td>用户身份证</td>
</tr>
<tr>
	<td>email</td>
	<td>用户邮箱</td>
</tr>
<tr>
	<td>mobile</td>
	<td>用户手机</td>
</tr>
<tr>
	<td>address</td>
	<td>用户地址</td>
</tr>
</table>

###Controller

**请求参数**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>String</td>
	<td>用户id（从表单中获得）</td>
</tr>
<tr>
	<td>username</td>
	<td>String</td>
	<td>用户姓名（从表单中获得）</td>
</tr>
<tr>
	<td>password</td>
	<td>String</td>
	<td>用户密码（从表单中获得）</td>
</tr>
<tr>
	<td>identity</td>
	<td>String</td>
	<td>用户身份证号（从表单中获得）</td>
</tr>
<tr>
	<td>email</td>
	<td>String</td>
	<td>用户邮箱（从表单中获得）</td>
</tr>
<tr>
	<td>mobile</td>
	<td>String</td>
	<td>用户手机（从表单中获得）</td>
</tr>
<tr>
	<td>address</td>
	<td>String</td>
	<td>用户收货地址（从表单中获得）</td>
</tr>
<tr>
	<td>updateList</td>
	<td>List</td>
	<td>存放用户属性</td>
</tr>
</table>

###删除用户

###View

**获取参数:**

<table>
<tr>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>鼠标点击的删除用户的id</td>
</tr>
</table>

###Controller

**获取参数**

<table>
<tr>
	<td>类型</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>String</td>
	<td>从js里获取的id</td>
</tr>
</table>

###调用方法:

<table>
<tr>
	<td>方法名</td>
	<td>返回类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>AddUser</td>
	<td>void</td>
	<td>增加用户</td>
</tr>
<tr>
	<td>DeleteUser</td>
	<td>void</td>
	<td>删除用户</td>
</tr>
<tr>
	<td>GetUser</td?
	<td>void</td>
	<td>获取用户信息</td>
</tr>
<tr>
	<td>UpdateUser</td>
	<td>void</td>
	<td>更新用户信息</td>
</tr>
</table>

##13.新闻管理

**URL:**
http://localhost:8080/manage/index.jsp

###新增新闻

###View

**参数:**
<table>
<tr>
	<td>参数</td>
	<td>说明</td>
</tr>
<tr>
	<td>title</td>
	<td>新闻标题</td>
</tr>
<tr>
	<td>content</td>
	<td>新闻内容</td>
</tr>
</table>

###Controller

**获取参数**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>title</td>
	<td>String</td>
	<td>新闻标题(从表单获取)</td>
</tr>
<tr>
	<td>content</td>
	<td>String</td>
	<td>新闻内容（从表单获取）</td>
</tr>
<tr>
	<td>date</td>
	<td>Date</td>
	<td>系统日期</td>
</tr>
<tr>
	<td>news</td>
	<td>list</td>
	<td>存放新闻各种属性</td>
</tr>
</table>

###获取新闻

###View

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>modifynews.do?action=get</td>
	<td></td>
	<td>调用servelt获取所有的新闻信息</td>
</tr>
</table>

###Controller

**请求参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>list</td>
	<td>List</td>
	<td>从数据库中获得所有的新闻信息</td>
</tr>
</table>

###修改新闻

###View

**参数:**

<table>
<tr>
	<td>参数</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>新闻id</td>
</tr>
<tr>
	<td>title</td>
	<td>新闻标题</td>
</tr>
<tr>
	<td>content</td>
	<td>新闻内容</td>
</tr>
</table>

###Controller

**获取参数:**

<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>String</td>
	<td>从表单中获取id</td>
</tr>
<tr>
	<td>title</td>
	<td>String</td>
	<td>从表单中获取新闻标题</td>
</tr>
<tr>
	<td>content</td>
	<td>String</td>
	<td>从表单中获取新闻内容</td>
</tr>
<tr>
	<td>date</td>
	<td>Date</td>
	<td>获取系统的日期</td>
</tr>
<tr>
	<td>userList</td>
	<td>List</td>
	<td>将新闻中的属性内容存到userList中</td>
</tr>
</table>


###删除新闻

###View

**参数:**

<table>
<tr>
	<td>参数</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>js中获取鼠标点击的新闻的id</td>
</tr>
</table>

###Controller

**获取参数:**

<table>
<tr>
	<td>获取参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>String</td>
	<td>从js里获取设置的id</td>
</tr>
</table>

###调用方法:

<table>
<tr>
	<td>方法名</td>
	<td>返回类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>AddNews</td>
	<td>void</td>
	<td>增加新闻</td>
</tr>
<tr>
	<td>DeleteNews</td>
	<td>void</td>
	<td>删除新闻</td>
</tr>
<tr>
	<td>UpdateNews</td>
	<td>void</td>
	<td>修改新闻</td>
</tr>
<tr>
	<td>GetNews</td>
	<td>void</td>
	<td>获取新闻信息</td>
</tr>
</table>

##14.商品管理
###删除商品
####view

**URL:**
http://localhost:8080/manage/product.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>PproductList</td>
	<td>List<EYProduct></td>
	<td>获取部分商品信息，将其显示在页面中（分页显示）</td>
</tr>
<tr>
	<td>PpageIndex</td>
	<td>int</td>
	<td>指示显示的是第几页</td>
</tr>
<tr>
	<td>PtotalPage</td>
	<td>int</td>
	<td>总页数</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/mpro.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>指示进行那种商品管理操作</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>指示要删除商品的Id</td>
</tr>
</table>
###增加商品
####view

**URL:**
http://localhost:8080/manage/product-add.jsp<br>
**请求参数**
<br>无
####controller

**URL:**
http://localhost:8080/mpro.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>指示进行那种商品管理操作</td>
</tr>
<tr>
	<td>photo</td>
	<td>file</td>
	<td>将图片添加至指定目录下</td>
</tr>
<tr>
	<td>productName</td>
	<td>String</td>
	<td>商品名称</td>
</tr>
<tr>
	<td>parentId</td>
	<td>int</td>
	<td>商品编号</td>
</tr>
<tr>
	<td>productPrice</td>
	<td>double</td>
	<td>商品价格</td>
</tr>
<tr>
	<td>productDescription</td>
	<td>String</td>
	<td>商品描述</td>
</tr>
<tr>
	<td>productStock</td>
	<td>int</td>
	<td>商品库存</td>
</tr>
</table>
###修改商品
####view

**URL:**
http://localhost:8080/manage/product-modify.jsp<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>获取商品编号，以便传给servlet</td>
</tr>
<tr>
	<td>name</td>
	<td>String</td>
	<td>商品名称栏默认显示</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/mpro.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
	<td>flag</td>
	<td>String</td>
	<td>指示进行那种商品管理操作</td>
<tr>
	<td>id</td>
	<td>int</td>
	<td>指示要修改的商品编号</td>
</tr>
<tr>
	<td>productName</td>
	<td>String</td>
	<td>传递修改后的商品名称</td>
</tr>
<tr>
	<td>parentId</td>
	<td>int</td>
	<td>传递修改后的商品编号</td>
</tr>
<tr>
	<td>productPrice</td>
	<td>double</td>
	<td>传递修改后的商品价格</td>
</tr>
<tr>
	<td>productDesciption</td>
	<td>String</td>
	<td>传递修改后的商品描述</td>
</tr>
<tr>
	<td>productStock</td>
	<td>int</td>
	<td>更新商品库存</td>
</tr>
</table>
###查看商品详情
###view

**URL:**
http://localhost:8080/product-view.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>pdetil</td>
	<td>EYProduct</td>
	<td>从servlet中获取某件商品的详细信息</td>
</tr>
</table>
###controller

**URL:**
http://localhost:8080/pro.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>根据商品Id获取相应商品</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>根据此标志判定servlet要执行那种操作</td>
</tr>
</table>
##15.订单管理
###删除订单
####view

**URL:**
http://localhost:8080/product-view.jsp<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>orderlist</td>
	<td>List<EYOrder></td>
	<td>获取订单，分页显示</td>
</tr>
<tr>
	<td>pageIndex</td>
	<td>int</td>
	<td>指示页面下标</td>
</tr>
<tr>
	<td>totalPage</td>
	<td>int</td>
	<td>指示页面总数</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/morder.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>指示要进行哪种订单管理</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>指出要删除的订单Id</td>
</tr>
<tr>
	<td>f</td>
	<td>String</td>
	<td>指出在哪个页面进行的订单删除操作，便于删除后的返回</td>
</tr>
</table>
###修改订单
####view

**URL:**
http://localhost:8080/manage/order-modify.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>id</td>
	<td>int</td>
	<td>显示要修改订单的订单号</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/morder.do
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>指示要进行哪种订单管理</td>
</tr>
<tr>
	<td>status</td>
	<td>int</td>
	<td>订单状态</td>
</tr>
<tr>
	<td>address</td>
	<td>String</td>
	<td>发货地址</td>
</tr>
</table>
###查询订单
####view

**URL:**
http://localhost:8080/manage/order-select.jsp
<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>orderlist</td>
	<td>List<EYOrder></td>
	<td>获取查询的订单，并显示</td>
</tr>
</table>
####controller

**URL:**
http://localhost:8080/morder.do<br>
**请求参数**
<table>
<tr>
	<td>参数</td>
	<td>类型</td>
	<td>说明</td>
</tr>
<tr>
	<td>flag</td>
	<td>String</td>
	<td>指示要进行哪种订单管理</td>
</tr>
<tr>
	<td>orderId</td>
	<td>int</td>
	<td>要查询订单的Id</td>
</tr>
<tr>
	<td>userName</td>
	<td>String</td>
	<td>要查询订单的用户姓名</td>
</tr>
</table>
