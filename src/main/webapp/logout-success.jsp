<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
	<h1>ログアウト画面</h1>
	<hr>
	<%
	String userName = (String) session.getAttribute("userName");
	%>
	<h4>
		お疲れさまでした！<%=userName%>さん
	</h4>
	<h1>ログアウトしました。</h1>
	<%
	session.invalidate();
	%>
	<div>
		<form action="login.jsp" method="POST">
			<input type="submit" value="ログイン画面へ">
		</form>
	</div>

</body>
</html>