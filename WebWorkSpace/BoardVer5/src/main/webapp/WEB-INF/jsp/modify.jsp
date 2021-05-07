<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글을 한번 고쳐보거라</h1>
	<form action="/modify" method="post">
		<input type="hidden" name="iboard" value="${ param.iboard }">
		<div>제목 : <input type="text" name="title" value="${ data.title }"></div>
		<div>내용 : <textarea rows="30" cols="50" name="ctnt">${ data.ctnt }</textarea></div>
		<input type="submit" value="수정">
		<input type="reset" value="초기화">
	</form>
	<button onclick="goToBack()">뒤로가기</button>
<script>
function goToBack() {
	window.history.back();
}
</script>
</body>
</html>