<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<div><h1>BoardList</h1></div>
	<div><a href="write">글쓰기</a></div>
	<div>
		<a href="/user/logout">logout</a>
	</div>
	<div>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>추천</th>
				<th>반대</th>
			</tr>
			<c:forEach var="i" items="${boardlist}">
				<tr class="record" onclick="moveToDetail(${i.iboard})">
					<td>${i.iboard }</td>
					<td>${i.title}</td>
					<td>${i.uid}</td>
					<td>${i.regdt}</td>
					<td>${i.viewcnt}</td>
					<td>${i.likecnt}</td>
					<td>${i.dislike}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<script>
function moveToDetail(iboard) {
	location.href="/board/detail?iboard="+iboard;
}

</script>
</body>
</html>