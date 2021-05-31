<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="/res/css/boardDetail.css">
<script defer src="/res/js/boardDetail.js"></script>

<h1>${ data.title }</h1>
<c:if test=""><i class="far fa-heart" id="likeIcon" onclick="slapLike(${data.iboard});"></i></c:if>
<c:if test=""><i class="fas fa-heart" onclick="cancleLike(${data.iboard});"></i></c:if>
<div>
	<c:out value="${ data.ctnt }" />
</div>
<div>글쓴이 : ${ data.writerNm }</div>
<div>작성일시 : ${ data.regdt }</div>
<button onclick="goBack()">목록</button>
<c:if test="${loginUser.iuser == data.iuser }">
	<div>
		<a href="modify?iboard=${ data.iboard }"><button>수정</button></a> <a
			href="delete?iboard=${ data.iboard }"><button>삭제</button></a>
	</div>
</c:if>
<div>
<c:if test="${not empty sessionScope.loginUser}">
	<form id="cmtFrm" onsubmit="return false"> <!-- dataset의 속성명iboard에 값 저장 -->
		<input type="text" id="cmt">
		<input type="button" value="댓글달기" onclick="regCmt();">
	</form>
</c:if>
</div>
<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}" data-iboard="${data.iboard}"></div>

<div id="modal" class="displayNone">
	<div class="modal_content">
		<form id="cmtModFrm" action="#">
			<input type="hidden" id="icmt">
			<input type="text" id="cmt">
		</form>
		<input type="button" value="댓글 수정" onclick="modAjax();">
		<input type="button" value="취소" onclick="closeModModal();">
	</div>
</div>

