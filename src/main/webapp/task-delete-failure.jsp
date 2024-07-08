<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskDeleteBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除失敗画面</title>
</head>
<body>
	<h1>削除失敗画面</h1>
	<hr>
	<%
	TaskDeleteBean taskResult = (TaskDeleteBean) session.getAttribute("taskDelete");
	%>

	<h2>次のデータを削除できませんでした。</h2>
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