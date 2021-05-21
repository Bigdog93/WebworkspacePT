<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div><h1>BoardList</h1></div>
	<div><a href="write"><button>글쓰기</button></a></div>
	<div>
		<a href="/user/logout"><button>logout</button></a>
	</div>
	<div>
		<form action="/board/list" method="get">
			<div>
				<input type="search" name="search" placeholder="검색어 입력" value="${param.search }">
				<input type="submit" value="검색">
			</div>
		</form>
		<a href="/board/list"><button>전체 글 보기</button></a>
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
					<td>${i.unm}</td>
					<td>${i.regdt}</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			${requestScope.totalPage}
			<c:forEach begin="1" end="${requestScope.totalPage}" var="cnt">
				<a href="list?page=${cnt}&search=${param.search}"><span>${cnt}</span></a>
			</c:forEach>
		</div>
	</div>
<!-- <script>
function moveToDetail(iboard) {
	location.href="/board/detail?iboard="+iboard;
}

</script> -->

