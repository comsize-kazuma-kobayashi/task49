<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.TaskAlterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク情報-編集入力フォーム</title>
</head>
<body>
	<h1>タスク情報-編集入力フォーム</h1>
	<hr>
	<%
	TaskAlterBean taskDetail = (TaskAlterBean) request.getAttribute("taskDetail");
	List<TaskAlterBean> categoryList = (List<TaskAlterBean>) request.getAttribute("categoryList");
	List<TaskAlterBean> statusList = (List<TaskAlterBean>) request.getAttribute("statusList");
	List<TaskAlterBean> userList = (List<TaskAlterBean>) request.getAttribute("userList");
	%>
	<br>

	<form action="TaskConfirmServlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="task_name"
					value="<%=taskDetail.getTaskName()%>"></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td><select name="select_category">

						<%
						for (TaskAlterBean category : categoryList) {
						%>
						<option
							value="<%=category.getCategoryId()%>,<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="text" size="100" name="limit_date"
					value="<%=taskDetail.getLimitDate()%>"></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><select name="select_user">

						<%
						for (TaskAlterBean user : userList) {
						%>
						<option value="<%=user.getUserId()%>,<%=user.getUserName()%>"><%=user.getUserName()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td><select name="select_status">

						<%
						for (TaskAlterBean status : statusList) {
						%>
						<option
							value="<%=status.getStatusCode()%>,<%=status.getStatusName()%>"><%=status.getStatusName()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<th>メモ</th>
				<td><input type="text" name="memo"
					value="<%=taskDetail.getMemo()%>"></td>
			</tr>
		</table>
		<input type="submit" value="編集する"> <input type="reset"
			value="リセット">
	</form>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>
	<br>

</body>
</html>