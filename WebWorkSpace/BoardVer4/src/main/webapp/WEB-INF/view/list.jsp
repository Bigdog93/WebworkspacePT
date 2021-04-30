<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table, th, td {
	border : 1px solid black;
	border-collapse : collapse;
}
.record {
	cursor: pointer;
}
.record:hover {
	background-color: #ecf0f1;
}
</style>
<title>리스트</title>
</head>
<body>
	<h1>글 목록이 뜰 것이니라</h1>
	<div>
		<a href="/write">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>작성시간</th>
			</tr>
			<c:forEach var="i" items="${list}" varStatus="status">
				<tr class="record" onclick="moveToDetail(${i.iboard})">
					<td>${ i.iboard }</td>
					<td>${ i.title }</td>
					<td>${ i.regdt }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<script type="text/javascript">
	function moveToDetail(iboard) {
		console.log('iboard : %d', iboard);
		location.href = '/detail?no=' + iboard;
	}
</script>
</body>
</html>