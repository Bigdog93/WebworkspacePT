<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div> 내용 <p>${ data.ctnt }</p></div>
		<div> 조회수 ${ data.viewcnt }</div>
	</div>
	<a href="/list"><button>목록으로 돌아가기</button></a>
	
	<form action="/comentWrite" method="post">
		<input type="hidden" name="iboard" value="${ param.no }">
		<div>Coment : <input type="text" name="cmt"><input type="text" name="cmtID" value="ID를 입력하세요">
		<input type="submit" value="댓글달기"></div>
	</form>
	<c:forEach var="i" items="${ cmt_data }">
	<form action="/comentDelete" method="post">
		<input type="hidden" name="no" value="${ param.no }">
		<input type="hidden" name="icmt" value="${ i.icmt }">
		<div>${ i.cmtID } : ${ i.cmt } 작성일 : ${ i.cmt_regdt } <input type="submit" value="삭제"></div>
	</form>
	</c:forEach>
</body>
</html>