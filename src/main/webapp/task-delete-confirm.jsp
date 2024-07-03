<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskDeleteBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
</head>
<body>
	<%
	TaskDeleteBean taskDelete = (TaskDeleteBean) session.getAttribute("taskDelete");
	%>

	<h1>削除確認画面</h1>
	<hr>
	<h2>タスク情報を削除します。よろしいですか？</h2>
	<br>
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><%=taskDelete.getTaskName()%></td>
			</tr>
			<tr>
				<th>カテゴリ名</th>
				<td><%=taskDelete.getCategoryName()%></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><%=taskDelete.getLimitDate()%></td>
			</tr>
			<tr>
				<th>ユーザー名</th>
				<td><%=taskDelete.getUserName()%></td>
			</tr>
			<tr>
				<th>ステータス名</th>
				<td><%=taskDelete.getStatusName()%></td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><%=taskDelete.getMemo()%></td>

			</tr>
		</table>
	<br>
	<form action="TaskDeleteServlet" method="POST">
		<input type="hidden" name="task_id" value="<%=taskDelete.getTaskId()%>">
		<input type="submit" value="削除する">
	</form>
	<br>
	<form action="item-detail.jsp" method="POST">
		<input type="submit" value="詳細表示へ">
	</form>
</body>
</html>