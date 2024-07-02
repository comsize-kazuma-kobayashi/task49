<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.TaskDisplayBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
</head>
<body>

	<%
	List<TaskDisplayBean> taskList = (List<TaskDisplayBean>) request.getAttribute("taskList");
	%>
	<h1>タスク一覧表示画面</h1>
	<hr>

	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>
		<%
		for (TaskDisplayBean task : taskList) {
		%>
		<tr>
			<td><%=task.getTaskName()%></td>
			<td><%=task.getCategoryName()%></td>
			<td><%=task.getLimitDate()%></td>
			<td><%=task.getUserName()%></td>
			<td><%=task.getStatusName()%></td>
			<td><%=task.getMemo()%></td>
		</tr>
		<%
		}
		%>
	</table>

	<td>
	<form action="" method="POST">
		<input type="submit" value="編集する">
	</form>
	</td>
	<td>
	<form action="" method="POST">
		<input type="submit" value="削除する">
	</form>
	</td>
	<br>
	<div>
		<form action="menu.jsp" method="POST">
			<input type="submit" value="メニュー画面へ">
		</form>
	</div>

</body>
</html>