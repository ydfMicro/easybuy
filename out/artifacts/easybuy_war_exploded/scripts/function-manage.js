// JavaScript Document
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "deleteUser.do?id=" + id;
	}
}

function DeleteUser(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "modifyuser.do?action=delete&id=" + id;
	}
}

function DeleteNews(id){
	if(confirm("确定要删除吗？")){
		location.href = "modifynews.do?action=delete&id=" + id;
	}
}
function DeleteOrder(id)
{
	if(confirm("确定要删除吗？")) {
		location.href ="/morder.do?flag=remove&id="+ id;
	}
}
function DeleteProduct(id)
{
	if(confirm("确定要删除吗？")) {
		location.href ="/mpro.do?flag=remove&id="+ id;
	}
}
