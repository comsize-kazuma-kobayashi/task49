<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskAlterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク情報-編集登録結果画面</title>
</head>
<body>
	<h1>タスク情報-編集登録結果画面</h1>
	<hr>
	<%
	TaskAlterBean updateTask = (TaskAlterBean) request.getAttribute("updateTask");
	%>
	
	<h2>次のデータの編集を登録しました。</h2>
	
	<br>
	<table border="1">
		<tr>
			<th align="left">タスク名</th>
			<td width="600"><%=updateTask.getTaskName()%></td>
		</tr>
		<tr>
			<th align="left">カテゴリ情報</th>
			<td><%=updateTask.getCategoryName()%></td>
		</tr>
		<tr>
			<th align="left">期限</th>
			<td><%=updateTask.getLimitDate()%></td>
		</tr>
		<tr>
			<th align="left">担当者情報</th>
			<td><%=updateTask.getUserName()%></td>
		</tr>
		<tr>
			<th align="left">ステータス情報</th>
			<td><%=updateTask.getStatusName()%></td>
		</tr>
		<tr>
			<th align="left">メモ</th>
			<td><%=updateTask.getMemo()%></td>
		</tr>
		
	</table>
	<br>
	</form>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="一覧画面へ">
	</form>

</body>
</html>