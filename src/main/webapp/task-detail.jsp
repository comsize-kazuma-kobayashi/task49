<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.ItemCategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
	<%
		ItemCategoryBean itemDetail = (ItemCategoryBean) session.getAttribute("itemDetail");
	%>
	<h1>商品詳細画面</h1>
	<hr>
	<table border="1">
		<tr>
			<th>商品コード</th>
			<td><%=itemDetail.getItemCode()%></td>
		</tr>
		<tr>
			<th>商品分類</th>
			<td><%=itemDetail.getCategoryName()%></td>
		</tr>
		<tr>
			<th>商品名</th>
			<td><%=itemDetail.getItemName()%></td>
		</tr>
		<tr>
			<th>価格</th>
			<td><%=itemDetail.getPrice()%>円</td>
		</tr>
	</table>
	<br>
	<table>
	<tr>
	<td>
	<form action="item-alter-form.jsp" method="POST">
		<input type="submit" value="変更する">
	</form>
	</td>
	<td>
	<form action="item-delete-confirm.jsp" method="POST">
		<input type="submit" value="削除する">
	</form>
	</td>
	<td>
	<form action="ItemListServlet" method="GET">
		<input type="submit" value="一覧表示">
	</form>
	</td>
	</tr>
	</table>
</body>
</html>