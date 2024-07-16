<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskRegBean,java.sql.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
</head>
<body>
	
	<% 
	TaskRegBean taskInfo = (TaskRegBean)session.getAttribute("taskInfo"); 
	%>
	<h1>登録完了画面</h1>
	<hr>
	<h2>登録完了しました。</h2>
	</hr>
	<br>
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><%=taskInfo.getTaskName()%></td>
			</tr>
			<tr>
				<th>カテゴリ名</th>
				<td><%=taskInfo.getCategoryid()%></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><%=taskInfo.getDate()%></td>
			</tr>
			<tr>
				<th>担当者</th>
				<td><%=taskInfo.getUserId()%></td>
			</tr>
			<tr>
				<th>ステータス</th>
				<td><%=taskInfo.getStatusCode()%></td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><%=taskInfo.getMemo()%></td>
			</tr>
		</table>
	<br>
	<form action="task-list.jsp" method="POST">
		<input type="submit" value="一覧表示画面へ">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニューへ">
	</form>
</body>
</html>