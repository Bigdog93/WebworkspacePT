<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="/user/login" method="post">
		<div>
			<input type="text" name="uid" placeholder="ID입력">
		</div>
		<div>
			<input type="password" name="upw" placeholder="PW입력">
		</div>
		<input type="submit" value="login">
	</form>
	<a href="/user/join"><button>join</button></a>
</body>
</html>