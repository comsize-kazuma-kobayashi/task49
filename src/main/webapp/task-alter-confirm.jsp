<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskAlterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク情報-編集確認画面</title>
</head>
<%
int taskId = (Integer)session.getAttribute("taskId");
TaskAlterBean taskAlter = (TaskAlterBean) request.getAttribute("taskAlter");

%>

<h1>タスク管理情報-タスク確認画面</h1>
<hr>

<h2>タスク管理情報を以下の内容に変更します。よろしいですか？</h2>
<br>
<br>
<form action="TaskAlterServlet" method="POST">
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=taskAlter.getTaskName()%><input type="hidden"
				name="task_name" value="<%=taskAlter.getTaskName()%>"></td>
		</tr>
		<tr>
			<th>カテゴリー情報</th>
			<td><%=taskAlter.getCategoryName()%><input type="hidden"
				name="category_name" value="<%=taskAlter.getCategoryName()%>"></td>
		</tr>
		<tr>
			<th>期限</th>
			<td><%=taskAlter.getLimitDate()%><input type="hidden"
				name="limit_date" value="<%=taskAlter.getLimitDate()%>"></td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><%=taskAlter.getUserName()%><input type="hidden"
				name="user_name" value="<%=taskAlter.getUserName()%>"></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><%=taskAlter.getStatusName()%><input type="hidden"
				name="status_name" value="<%=taskAlter.getStatusName()%>"></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=taskAlter.getMemo()%><input type="hidden"
				name="memo" value="<%=taskAlter.getMemo()%>"></td>
		</tr>
		
	</table>
	<br> <input type="submit" value="編集する"> <input
		type="hidden" name="task_id"
		value="<%=taskId%>">
</form>
<br>
<form action="menu.jsp" method="POST">
	<input type="hidden" name="task_id"
		value="<%=taskId%>"> <input type="submit"
		value="メニュー画面へ">
</form>
</body>
</html>