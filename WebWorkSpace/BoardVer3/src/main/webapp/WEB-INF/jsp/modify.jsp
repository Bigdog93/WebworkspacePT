<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하는거지</title>
</head>
<body>
	<h1>글수정</h1>
	<a href="/list">돌아가기</a>
	<form action="/modify" method="post">
		<input type="hidden" name="no" value="${ param.no }">
		<div>
			제목 : <input type="text" name="title" value="${ data.title }">
		</div>
		<div>
			내용 : <textarea rows="25" cols="100" name="ctnt">${ data.ctnt }</textarea>
		</div>
		<input type="submit" value="수정하기">
		<input type="reset" value="초기화">
	</form>
</body>
</html>