<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>
	<h1>글수정</h1>
	<form action="modify" method="post">
		<input type="hidden" name="iboard" value="${ param.iboard }">
		<div>제목 : <input type="text" name="title" placeholder="제목" value="${ data.title }"></div>
		<div>내용 : <textarea rows="30" cols="30" name="ctnt">${ data.ctnt }</textarea></div>
		<input type="submit" value="수정">
		<input type="reset" value="초기화">
	</form>
</body>
</html>