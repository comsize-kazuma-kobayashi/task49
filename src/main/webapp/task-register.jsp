<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.entity.UserBean, java.util.List, model.entity.CategoryOptionBean, model.entity.StatusOptionBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>

	<%
	//sessionで上がっている"userInfo"を取得して、userInfoに代入
	UserBean userInfo = (UserBean) session.getAttribute("userInfo");
	List<CategoryOptionBean> categoryList = (List<CategoryOptionBean>) session.getAttribute("categoryOptionList");
	List<StatusOptionBean> statusList = (List<StatusOptionBean>) session.getAttribute("statusOptionList");
	%>

	<h1>タスク登録画面</h1>
	<hr>
	<form action="TaskRegServlet" method="POST">
		<table>

			<tr>
				<th>タスク名</th>
				<td><input type="text" name="task_name" required></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td><select name="category_id">
						<%
						for (CategoryOptionBean category : categoryList) {
						%>

						<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%>
						</option>
						<%
						}
						%>
						
				</select>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="date" name="limit_date" value="limitdate"></td>
			</tr>


			<tr>
				<th>担当者情報</th>
				<td><%=userInfo.getUserName()%></td>
			</tr>


			<tr>
				<th>ステータス情報</th>
				<td><select name="status_code">
						<%
						for (StatusOptionBean status : statusList) {
						%>
						<option value="<%=status.getStatusCode()%>"><%=status.getStatusName()%></option>
						<%
						}
						%>
				</select>
			</tr>

			<tr>
				<th>メモ</th>
				<td><input type=text name=memo size="30" maxlength="100"></td>

			</tr>

		</table>
		<input type="submit" value="送信">
	</form>

</body>
</html>