<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<script defer src="/res/js/boarddetail.js"></script>
<link rel="stylesheet" href="/res/css/boardList.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- 외부에 오픈되어있는 CSS파일 사용법. (CDN) -->
<style>
.hidden {
	display : none !important; /* important주면 최고 우선순위 */
}
.fa-heart {color : red;}
</style>
<title>detail</title>
</head>
<body>
	<h1>${ data.title }
		<c:if test="${data.isLike eq 0}">
		<a href="like?iboard=${data.iboard}&like=1"><i class="far fa-heart"></i></a>
		</c:if>
		<c:if test="${data.isLike eq 1}">
		<a href="like?iboard=${data.iboard}&like=0"><i class="fas fa-heart"></i></a> <!-- 여러개의 클래스를 부여할때는 띄어쓰기로 구분 -->
		</c:if>
	</h1>
	<div>
		${ data.ctnt }
	</div>
	<div>글쓴이 : ${ data.uid }</div>
	<div>작성일시 : ${ data.regdt }</div>
	<button onclick="moveToList()">목록</button>
	<c:if test="${loginUser.iuser == data.iuser }">
		<div><a href="modify?iboard=${ data.iboard }"><button>수정</button></a> <a href="delete?iboard=${ data.iboard }"><button>삭제</button></a></div>
	</c:if>
	<div>
		<form id="insFrm" action="cmt" method="post">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${ data.iboard }">
			<div>
				<textarea name="cmt" placeholder="댓글쓰기"></textarea><input type="submit" value="작성">
			</div>
		</form>
		
		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${ data.iboard }">
			<div>
				<textarea name="cmt" placeholder="댓글쓰기"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="수정취소" onclick="showInsFrm()">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>작성자</th>
				<th>내용</th>
				<th>추천</th>
				<th>반대</th>
				<th>작성일</th>
				<th></th>
			</tr>
			<c:forEach var="i" items="${cmtlist}" varStatus="vs"> <!-- jstl의 forEach문에서는 items에 있는 애들을 각각 pageContext에 담아 사용한다. -->
			<!-- EL식을 쓸 수 있다는건 pageContext, request, session, application 중 한곳에 있다는 이야기. -->
			<!-- 내장객체의 종류는 이 외에도 많지만 set, get 쓸수있는 애는 얘네 넷 밖에 없다. -->
				<tr>
					<td>${ i.uid }</td>
					<td>${ i.cmt }</td>
					<td>${ i.likecnt }</td>
					<td>${ i.dislike }</td>
					<td>${ i.regdt }</td>
					<td>
					<c:if test="${sessionScope.loginUser.iuser == i.iuser}">
						<button onclick="updCmt(${i.icmt}, '${i.cmt.trim()}')">수정</button> <!-- a태그 쓸때는 버튼 바깥으로 -->
						<!-- 자바스크립트 파라미터 넘겨줄때, 문자열자료는 ''로 감싸줄것.(아니면 변수명으로 취급함) -->
						<%-- <a href="cmt?icmt=${i.icmt}&iboard=${data.iboard}"> --%><button onclick="delCmt(${data.iboard}, ${i.icmt})">삭제</button> <!-- button의 type의 default는 "submit"이다. -->
						<!-- 그래서 form 태그 안에서 button태그 쓸때는 조심해야 한다. -->
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>