<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskAlterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集失敗画面</title>
</head>
<body>
	<h1>編集失敗画面</h1>
	<hr>
	<%
	TaskAlterBean taskResult = (TaskAlterBean) request.getAttribute("updateTask");
	%>

	<h2>データを編集できませんでした。</h2>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=taskResult.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ名</th>
			<td><%=taskResult.getCategoryName()%></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><%=taskResult.getLimitDate()%></td>
		</tr>
		<tr>
			<th>ユーザー名</th>
			<td><%=taskResult.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス名</th>
			<td><%=taskResult.getStatusName()%></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=taskResult.getMemo()%></td>
		</tr>
	</table>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>

</body>
</html>