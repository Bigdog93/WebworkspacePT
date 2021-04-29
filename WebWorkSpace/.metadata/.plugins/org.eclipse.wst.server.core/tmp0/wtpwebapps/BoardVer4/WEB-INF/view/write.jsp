<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/write" method="post">
		<div>제목 : <input type="text" name="title"></div>
		<div>내용 : <textarea rows="30" cols="50" name="ctnt"></textarea> </div> <!-- 요새 잘 안쓰는 태그.. -->
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</form>
	<a href="/list">돌아가기</a>
</body>
</html>