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
		<h2>新增用户</h2>
		<div class="manage">
			<form action="/modifyuser.do?action=add" method="post">
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="userName" value=""  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="passWord" value=""  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td>
							<input type="radio" name="sex" value="男" checked="checked" />男
							<input type="radio" name="sex" value="女" />女
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<select name="birthyear">
								<option value="2000">2000</option>
								<option value="1999">1999</option>
								<option value="1998">1998</option>
								<option value="1997">1997</option>
								<option value="1996">1996</option>
								<option value="1995">1995</option>
							</select>年
							<select name="birthmonth">
								<option value="12">12</option>
								<option value="11">11</option>
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select>月
							<select name="birthday">
								<option value="31">31</option>
								<option value="30">30</option>
								<option value="29">29</option>
								<option value="28">28</option>
								<option value="27">27</option>
								<option value="26">26</option>
								<option value="25">25</option>
								<option value="24">24</option>
								<option value="23">23</option>
								<option value="22">22</option>
								<option value="21">21</option>
								<option value="20">20</option>
								<option value="19">19</option>
								<option value="18">18</option>
								<option value="17">17</option>
								<option value="16">16</option>
								<option value="15">15</option>
								<option value="14">14</option>
								<option value="13">13</option>
								<option value="12">12</option>
								<option value="11">11</option>
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select>日
						</td>
					</tr>
					<tr>
						<td class="field">身份证号：</td>
						<td><input type="text" class="text" name="identity_code" value=""  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email" value="" style="width:150px" />
							<select name="email_Suffix">
							<option value="@qq.com">@qq.com</option>
							<option value="@163.com">@163.com</option>
							<option value="@126.com">@126.com</option>
							<option value="@outlook.com">@outlook.com</option>
						    </select>
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value=""  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" value=""  style="width:150px" /></td>
					</tr>
					<tr>
						<td class="field">用户类型：</td>
						<td>
							<select name="status">
							<option value="1">会员</option>
							<option value="2">管理员</option>
						    </select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
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
