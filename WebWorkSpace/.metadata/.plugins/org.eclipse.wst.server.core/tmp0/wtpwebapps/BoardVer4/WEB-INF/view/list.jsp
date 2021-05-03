<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>리스트</title>
</head>
<body>
	<h1>글 목록이 뜰 것이니라</h1>
	<div>
		<a href="/write">글쓰기</a>
	</div>
	<div>
	<form action="/list" method="post">
		<div>검색 : <input type="text" name="word" value="${ param.word }"> <input type="submit" value="찾아보기"> </div>
	</form>
	<button onclick="moveBackToList()">전체 리스트</button>
		<table>
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성시간</th>
				<th>댓글 수</th>
			</tr>
			<c:forEach var="i" items="${list}" varStatus="status">
				<tr class="record" onclick="moveToDetail(${i.iboard})"> 
				<!-- onclick을 쓰는 이유는!? 번호든 제목이든 날짜는 클릭하면 되야하는데 a태그를 쓰려면 각 요소마다 해줘야 해서!! -->
					<td>${ i.iboard }</td>
					<td>${ i.title }</td>
					<td>${ i.viewcnt }</td>
					<td>${ i.regdt }</td>
					<td>${ i.cmt_cnt }</td>
				</tr>
			</c:forEach>
		</table>
	</div>


<script type="text/javascript">
	function moveToDetail(iboard) {
		console.log('iboard : %d', iboard);
		location.href = '/detail?no=' + iboard;
	}
	function moveBackToList() {
		location.href = '/list';
	}
</script>
</body>
</html>