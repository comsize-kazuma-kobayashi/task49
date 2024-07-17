<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,model.entity.TaskRegBean,java.sql.Date,model.entity.UserBean,java.util.List,model.entity.CategoryOptionBean, model.entity.StatusOptionBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
</head>
<body>

	<%
	UserBean userInfo = (UserBean) session.getAttribute("userInfo");
	TaskRegBean taskInfo = (TaskRegBean) session.getAttribute("taskInfo");
	List<CategoryOptionBean> categoryList = (List<CategoryOptionBean>) session.getAttribute("categoryOptionList");
	List<StatusOptionBean> statusList = (List<StatusOptionBean>) session.getAttribute("statusOptionList");
	%>

	<h1>登録完了画面</h1>
	<hr>
	<h2>登録完了しました。</h2>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=taskInfo.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ名</th>
			<%
			for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getCategoryId() == taskInfo.getCategoryid()) {
			%>
			<td><%=categoryList.get(i).getCategoryName()%></td>
			<%
			}
			}
			%>
		</tr>
		<tr>
			<th>期限</th>
			<td><%=taskInfo.getDate()%></td>
		</tr>
		<tr>
			<th>ユーザー名</th>
			<td><%=userInfo.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス名</th>
			<%
			for (int i = 0; i < statusList.size(); i++) {
			if (statusList.get(i).getStatusCode().equals(taskInfo.getStatusCode())) {
			%>
			<td><%=statusList.get(i).getStatusName()%></td>
			<%
			}
			}
			%>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=taskInfo.getMemo()%></td>
		</tr>
	</table>
	<br>
	<form action="TaskListServlet" method="POST">
		<input type="submit" value="一覧表示画面へ">
	</form>
	<br>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニューへ">
	</form>
</body>
</html>