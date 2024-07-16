<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.ItemCategoryBean,model.entity.CategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-変更入力フォーム</title>
</head>
<body>
	<h1>商品情報-変更入力フォーム</h1>
	<hr>
	<%
	ItemCategoryBean itemDetail = (ItemCategoryBean) session.getAttribute("itemDetail");
	List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
	%>
	<br>

	<form action="ItemConfirmServlet" method="POST">
		<table border="1">
			<tr>
				<th>商品コード</th>
				<td><%=itemDetail.getItemCode()%></td>
			</tr>
			<tr>
				<th>商品分類</th>
				<td><select name="select_category">

						<%
						for (CategoryBean category : categoryList) {
						%>
						<option
							value="<%=category.getCategoryId()%>,<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>商品名</th>
				<td><input type="text" size="100" name="item_name"
					value="<%=itemDetail.getItemName()%>" ></td>
			</tr>
			<tr>
				<th>価格</th>
				<td><input type="number" name="price"
					value="<%=itemDetail.getPrice()%>">円</td>
			</tr>
		</table>
			<input type="submit" value="変更する">
	</form>
	<br>
	<form
		action="ItemDetailServlet?item_code=<%=itemDetail.getItemCode()%>"
		method="GET">
		<input type="hidden" value="<%=itemDetail.getItemCode()%>"
			name="item_code"> <input type="submit" value="キャンセル">
	</form>
</body>
</html>