<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.TaskDisplayBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
</head>
<body>

	<%
	List<TaskDisplayBean> taskDisplayList = (List<TaskDisplayBean>) session.getAttribute("taskDisplayList");
	%>
	<h1>タスク一覧表示画面</h1>
	<hr>

	<table border="1">
		<tr>
			<th></th>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>
		<%
		for (TaskDisplayBean task : taskDisplayList) {
		%>
		<tr>
			<td>
				<form method="POST">
					<input type="radio" name="taskId" value="<%=task.getTaskId()%>" required>
			</td>
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
	<table>
		<tr>
			<td><input type="submit" formaction="TaskAlterFormServlet" value="編集する"></td>
			<td><input type="submit" formaction="DeleteSelectServlet" value="削除する">
				</form></td>
			<br>
			<td>
				<form action="menu.jsp" method="POST">
					<input type="submit" value="メニュー画面へ">
				</form>
			</td>
		</tr>
	</table>

</body>
</html>