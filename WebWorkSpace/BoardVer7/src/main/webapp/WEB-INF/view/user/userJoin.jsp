<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
	<h1>Join</h1>
	<a href="login">취소</a>
	<div>${errMsg }</div>
	<form action="join" method="post">
		<div>ID : <input type="text" name="uid" placeholder="아이디"></div>
		<div>PW : <input type="password" name="upw" placeholder="비밀번호"></div>
		<div>이름 : <input type="text" name="unm" placeholder="이름"></div>
		<div>
			성별: 남자<input type="radio" name="gender" value="1" checked>  여자<input type="radio" name="gender" value="0">
		</div>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>