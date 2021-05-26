<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script defer src="/res/js/boardDetail.js"></script>

<h1>${ data.title }</h1>
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
	<form id="cmtFrm" data-iboard="${data.iboard}" onsubmit="return false"> <!-- dataset의 속성명iboard에 값 저장 -->
		<input type="text" id="cmt">
		<input type="button" value="댓글달기" onclick="regCmt();">
	</form>
</div>
<div id="cmtlist"></div>