<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>${ data.title }</title>
</head>
<body>
	<div>
		<h1>${ data.title }</h1>
		<p>${ data.ctnt }</p>
	</div>
	<div>글쓴이 : ${ data.unm }</div>
	<div>작성일 : ${ data.regdt }</div>
	<table>
		<tr>
			<th>조회수</th>
			<th>추천</th>
			<th>반대</th>
		</tr>
		<tr>
			<td>${ data.viewcnt }</td>
			<td>${ data.likecnt }</td>
			<td>${ data.dislike }</td>
		</tr>
	</table>
	<c:if test="${loginUser.iuser == data.iuser }">
		<div> <!--  세션에 저장된 애   		리퀘스트에서 온 애 -->
			<a href="delete?iboard=${ data.iboard }">삭제</a> <a href="modify?iboard=${ data.iboard }">수정</a>
		</div>
	</c:if>
	<form action="/coment/write" method="post">
		<input type="hidden" name="iboard" value="${ data.iboard }">
		<div>${ loginUser.uid } <input type="text" name="cmt_ctnt" placeholder="댓글쓰기"><input type="submit" value="작성"></div>
	</form>
	<c:forEach var="i" items="${ cmts }">
		<div>${ i.uid } : ${ i.ctnt } | ${ i.regdt } 추천 : ${ i.likecnt } / 반대 : ${ i.dislike }
			<c:if test="${ loginUser.iuser == data.iuser }">
				<form action="/coment/delete" method="post">
					<input type="hidden" name="iboard" value="${ data.iboard }">
					<input type="hidden" name="icmt" value="${ i.icmt }">
					<input type="submit" value="삭제">
				</form>
			</c:if>
		</div>
	</c:forEach>

</body>
</html>