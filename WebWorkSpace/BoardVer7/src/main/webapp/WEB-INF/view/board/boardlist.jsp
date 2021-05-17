<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<script defer src="/res/js/boardList.js?ver=2"></script> 
<!-- 외부 javascript파일 임포트. defer속성은 웹페이지 파싱이 끝난후 임포트를 수행하게 하는 속성
	없으면 파싱 끝나기 전에 수행
	async : 파싱하면서 같이 수행 -->
<!-- jsp파일 먼저 보낸후, jsp파일 파싱 수행중에 script, link태그를 만나면 src속성의 경로의 파일을 다운 받는 메커니즘 -->
<!-- js파일 또는 css파일 같이 외부에서 로드하는 파일을 수정했는데 반영이 안될경우, 이미 캐시에 저장이 되어있기 때문에 새로 다운받지 않는것. 쿼리스트링으로 ver를 주면
	새로 다운 받기 때문에 적용이 된다. -->
<link rel="stylesheet" type="text/css" href="/res/css/boardList.css">
</head>
<body>
	<div><h1>BoardList</h1></div>
	<div><h2>${ sessionScope.loginUser.unm }(${ loginUser.uid })님 환영합니다~</h2></div>
	<!-- sessionScope.으로 하면 pageContext와 request를 거치지않고 바로 session을 본다. -->
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
			<c:forEach var="i" items="${requestScope.boardlist}">
				<tr class="record" onclick="moveToDetail(${i.iboard})">
					<td>${i.iboard }</td>
					<!-- 얘네는 pageContext에 저장되는 아이들. pageScope로 지정해줄 순 있으나, 어차피 EL식은 pageContext부터 탐색하기 때문 -->
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
<!-- <script>
function moveToDetail(iboard) {
	location.href="/board/detail?iboard="+iboard;
}

</script> -->
</body>
</html>