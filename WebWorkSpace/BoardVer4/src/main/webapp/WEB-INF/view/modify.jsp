<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글을 수정한다</title>
</head>
<body>
	<form action="/modify" method="post">
		<input type="hidden" name="no" value="${ param.no }">
		<div>제목 : <input type="text" name="title" value="${ data.title }"></div>
		<div>내용 : <textarea rows="30" cols="50" name="ctnt">${ data.ctnt }</textarea> </div> <!-- 요새 잘 안쓰는 태그.. -->
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</form>
	<a href="/list">돌아가기</a>
</body>
</html>