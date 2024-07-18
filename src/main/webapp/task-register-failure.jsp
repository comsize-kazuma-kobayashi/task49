<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録失敗画面</title>
</head>
<body>
	登録失敗しました。
	
	<form action="TaskRegOptionServlet" method="POST">
		<input type="submit" value="タスク登録画面へ">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニューへ">
	</form>
</body>
</html>