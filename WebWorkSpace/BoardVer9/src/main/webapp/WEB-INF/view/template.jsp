<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/common.css"> <!-- 브라우저가 문자열로 되어있는 HTML을 읽다가 얘 만나면 다운로드 요청을 또 보낸다.(HTML 불러올때 같이 데려오는게 아니다.) -->
<script defer src="/res/js/common.js"></script>
<title>${requestScope.title}</title>
</head>
<body>
	<header>
		<nav class="navigation">
			<ul>
				<c:if test="${empty sessionScope.loginUser}">
					<li><a href="/user/login">로그인</a><li>
				</c:if>
				<c:if test="${not empty sessionScope.loginUser}">
					<li><a href="/user/logout">로그아웃</a><li>
					<li><a href="/board/write">글쓰기</a></li>
					<li><a href="/board/favoriteList">좋아요</a></li>
				</c:if>
				<li><a href="/board/list">리스트</a></li>
			</ul>
		</nav>
	</header>
	<section>
		<jsp:include page="/WEB-INF/view/${requestScope.page}.jsp"></jsp:include>
	</section>
</body>
</html>