<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용을 봐부러</title>
</head>
<body>
	<a href="/modify?no=${ param.no }"><button>수정</button></a>
	<a href="/delete?no=${ param.no }"><button>삭제</button></a>
	<div>
		<div><h1>${ data.title }</h1></div>
		<div> 작성일 : ${ data.regdt }</div>
		<div> 내용 : <p>${ data.ctnt }</p></div>
	</div>
	<a href="/list"><button>목록으로 돌아가기</button></a>
</body>
</html>