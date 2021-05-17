<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<script defer src="/res/js/boarddetail.js"></script>
<link rel="stylesheet" href="/res/css/boardlist.css">
</head>
<body>
	<h1>${ data.title }</h1>
	<div>
		${ data.ctnt }
	</div>
	<div>글쓴이 : ${ data.uid }</div>
	<div>작성일시 : ${ data.regdt }</div>
	<button onclick="moveToBack()">뒤로가기</button>
	<c:if test="${loginUser.iuser == data.iuser }">
		<div><a href="modify?iboard=${ data.iboard }&iuser=${data.iuser}"><button>수정</button></a> <a href="delete?iboard=${ data.iboard }&iuser=${data.iuser}"><button>삭제</button></a></div>
	</c:if>
	<div>
		<form action="cmt" method="post">
			<input type="hidden" name="iboard" value="${ data.iboard }">
			<div>
				<textarea name="cmt" placeholder="댓글쓰기"></textarea><input type="submit" value="작성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>작성자</th>
				<th>내용</th>
				<th>추천</th>
				<th>반대</th>
				<th>작성일</th>
				<th></th>
			</tr>
			<c:forEach var="i" items="${cmtlist}">
				<tr>
					<td>${ i.uid }</td>
					<td>${ i.cmt }</td>
					<td>${ i.likecnt }</td>
					<td>${ i.dislike }</td>
					<td>${ i.regdt }</td>
					<td>
					<c:if test="${sessionScope.loginUser.iuser == i.iuser}">
						<button>수정</button> <!-- a태그 쓸때는 버튼 바깥으로 -->
						<%-- <a href="cmt?icmt=${i.icmt}&iboard=${data.iboard}"> --%><button onclick="delCmt(${data.iboard}, ${i.icmt})">삭제</button> <!-- button의 type의 default는 "submit"이다. -->
						<!-- 그래서 form 태그 안에서 button태그 쓸때는 조심해야 한다. -->
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>