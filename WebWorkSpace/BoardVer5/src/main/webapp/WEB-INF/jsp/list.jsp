<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table, th, td {
	border : 1px solid black;
	border-collapse: collapse;
}
</style>
<title>목록</title>
</head>
<body>
	<h1>글이 뿌려질 곳이니라~!</h1>
	<div><a href="/write">글쓰기</a></div>
	<form action="/list" method="post">
		<div><input type="text" name="title" value="${param.title}"><input type="submit" value="검색"></div>
	</form>
	<div><button onclick="backToList()">전체 글 보기</button></div>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>추천</th>
			<th>반대</th>
			<th>댓글수</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr class="record" onclick="moveToDetail(${i.iboard})">
				<td>${ i.iboard }</td>
				<td>${ i.title }</td>
				<td>${ i.viewcnt }</td>
				<td>${ i.likecnt }</td>
				<td>${ i.dislike }</td>
				<td>${ i.cmtcnt }</td>
				<td>${ i.regdt }</td>
			</tr>
		</c:forEach>
	</table>
<script>
	function moveToDetail(iboard) {
		location.href = "/detail?iboard=" + iboard;
	}
	function backToList() {
		location.href="/list";
	}
</script>
</body>
</html>