<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="/res/js/userlogin.js"></script>
<style>
.err {
	color : red;
	display: none;
}
</style>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<div class="err">${ errMsg }</div>
	<form action="login" method="post">
		<div><input type="text" name="uid" placeholder="ID입력"></div>
		<div><input type="password" name="upw" placeholder="PW입력"></div>
		<input type="submit" value="로그인">
	</form>
	
	<div>
		<a href="join">join</a>
	</div>
</body>
</html>