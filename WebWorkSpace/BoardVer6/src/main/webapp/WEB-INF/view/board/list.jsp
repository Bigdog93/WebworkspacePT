<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Dutanic list</title>
<style>
table, th, td {
	border : 1px solid black;
	border-collapse: collapse;
}
.record:hover {
	background-color: 
}
</style>
</head>
<body>
	<div>로그인 성공</div>
	<div><h1>${ loginUser.unm }(${ loginUser.uid })님 환영합니다!!</h1><a href="/user/logout">Logout</a></div>
	
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="i" items="${list}">
				<tr class="record" onclick="moveToDetail(${i.iboard})">
					<td>${ i.iboard }</td>
					<td>${ i.title }</td>
					<td>${ i.unm }</td>
					<td>${ i.regdt }</td>
				<tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>