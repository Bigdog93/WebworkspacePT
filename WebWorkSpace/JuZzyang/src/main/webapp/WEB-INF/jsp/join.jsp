<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="/login" method="post">
		<div>ID : <input type="text" name="idvalue"></div>
		<div>PW : <input type="password" name="pwvalue"></div>
		<div>성별 : 
			<select name="gender">
				<option value="">선택</option>
				<option value="남">남자</option>
				<option value="여">여자</option>
			</select>
		</div>
		<div>나이 : 
			<select name="age">
				<c:forEach var="i" begin="19" end="120" step="1">
					<option value="${ i }">${i}</option>
				</c:forEach>
			</select>
		</div>
		<div>이름 : <input type="text" name="name"></div>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>