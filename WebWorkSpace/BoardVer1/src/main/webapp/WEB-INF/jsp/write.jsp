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
	<form action="/write" method="post"> <!-- form의 기본속성 두가지
	action은 form으로 감싸져있는 곳 안에 있는 애들을 데리고 갈 곳. 
	method는 get으로 할지 post로 할지
	post가 get 보다는 감춘다.(주소창에 나타나지 않는다.)
	get은 자료를 날릴때 쿼리스트링(?키=밸류&키=밸류)을 쓰는데 길이 제한이 있기때문에 큰 자료는 옮길 수 없다.
	가볍게 날릴때는 get 방식
	큰 자료, 비밀번호, 긴 글 등은 post
	post방식은 처리
	get방식은 화면 띄울때
	-->
		<div>
			제목 : <input type="text" name="title"> <!-- name 속성값이 key값이 된다. id, class는 해당 안됨. 안에 적혀있는게 value값이다. -->
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기"> <!-- 얘가 방아쇠. 누르면 빵 하고 get방식으로 /write로 보내줌 -->
			<input type="reset" value="초기화"> <!-- 초기화 시킨다. -->
		</div>
	</form>
	
</body>
</html>