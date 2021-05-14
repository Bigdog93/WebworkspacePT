<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="write" method="post">
		<div>제목 : <input type="text" name="title" placeholder="제목"></div>
		<div>내용 : <textarea rows="30" cols="30" name="ctnt"></textarea></div>
		<input type="submit" value="작성">
		<input type="reset" value="초기화">
	</form>
</body>
</html>