<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<h1>수정 하거라</h1>
	<div>
		<form action="modify" method="post">
		<input type="hidden" name="iboard" value="${data.iboard}" readonly> <!-- readonly속성 : 수정을 불가능하게 만듬 -->
			<div><input type="text" name="title" placeholder="제목" value="${data.title}"></div>
			<div><textarea name="ctnt" placeholder="내용">${ data.ctnt }</textarea></div>
			<div>
				<input type="submit" value="수정하기">
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>