<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>メニュー画面</title>

</head>

<body>

	<h1>メニュー画面</h1>

	<hr>

	<form action="TaskAddServlet" method="get">

		<input type="submit" value="商品登録">

	</form><br>
	
	<form action="TaskListServlet" method="post">

		<input type="submit" value="商品一覧">

	</form><br>

	<form action="logout-success.jsp" method="post">

		<input type="submit" value="ログアウト">

	</form>

</body>

</html>