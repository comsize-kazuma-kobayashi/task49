<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.entity.TaskRegBean,java.sql.Date,model.entity.UserBean,java.util.List,model.entity.CategoryOptionBean, model.entity.StatusOptionBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
</head>
<body>
	
	<h1>登録完了画面</h1>
	<hr>
	<h2>登録完了しました。</h2>
	</hr>

	<form action="TaskListServlet" method="POST">
		<input type="submit" value="一覧表示画面へ">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニューへ">
	</form>
</body>
</html>