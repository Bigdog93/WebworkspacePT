<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	<a href="/list">돌아가기</a>
	<form action="/write" method="post">	
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea rows="25" cols="100" name="ctnt"></textarea>
		</div>
		<input type="submit" value="글쓰기">
		<input type="reset" value="초기화">
	</form>
</body>
</html>