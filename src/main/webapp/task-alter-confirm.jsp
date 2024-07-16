<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.ItemCategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-変更確認画面</title>
</head>
<%
ItemCategoryBean itemDetail = (ItemCategoryBean) session.getAttribute("itemDetail");
ItemCategoryBean alterItem = (ItemCategoryBean) request.getAttribute("alterItem");
%>

<h1>商品情報-変更確認画面</h1>
<hr>

<h2>商品情報を以下の内容に変更します。よろしいですか？</h2>
<br>
<br>
<form action="ItemAlterServlet" method="POST">
	<table border="1">
		<tr>
			<th>商品コード</th>
			<td><%=itemDetail.getItemCode()%><input type="hidden"
				name="item_code" value="<%=itemDetail.getItemCode()%>"></td>
		</tr>
		<tr>
			<th>商品分類</th>
			<td><%=alterItem.getCategoryName()%><input type="hidden"
				name="category_name" value="<%=alterItem.getCategoryName()%>"></td>
		</tr>
		<tr>
			<th>商品名</th>
			<td><%=alterItem.getItemName()%><input type="hidden"
				name="item_name" value="<%=alterItem.getItemName()%>"></td>
		</tr>
		<tr>
			<th>価格</th>
			<td><%=alterItem.getPrice()%>円<input type="hidden" name="price"
				value="<%=alterItem.getPrice()%>"></td>
		</tr>
	</table>
	<br> <input type="submit" value="変更する"> <input
		type="hidden" name="category_code"
		value="<%=alterItem.getCategoryId()%>">
</form>
<br>
<form action="item-alter-form.jsp" method="POST">
	<input type="hidden" name="item_code"
		value="<%=itemDetail.getItemCode()%>"> <input type="submit"
		value="変更入力フォームへ">
</form>
</body>
</html>