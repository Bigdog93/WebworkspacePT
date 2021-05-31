<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/res/css/boardList.css">
<script defer src="/res/js/boardList.js"></script>
<h1>리스트인 게야</h1>

<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>작성일시</th>
	</tr>
	<c:forEach items="${requestScope.list}" var="i">
		<tr class="record" onclick="moveToDetail(${i.iboard})">
			<td>${i.iboard}</td>
			<td>
				<!-- EL식으로 문자열 합칠때는 += 로 해야한다. --> <c:choose>
					<c:when test="${param.searchType==1 || param.searchType==2}">
						${i.title.replace(param.searchText, '<mark>' += param.searchText += '</mark>')}
					</c:when>
					<c:otherwise>${i.title}</c:otherwise>
				</c:choose>
			</td>
			<c:choose>
				<c:when test="${empty i.profileImg }">
					<c:set var="img" value="/res/img/defaultprofile.jpg" />
				</c:when>
				<c:otherwise>
					<c:set var="img"
						value="/res/img/user/${i.iuser}/${i.profileImg}" />
				</c:otherwise>
			</c:choose>
			<td>
				<c:choose>
					<c:when test="${param.searchType == 4}">
						${i.writerNm.replace(param.searchText, '<mark>' += param.searchText += '</mark>')}
					</c:when>
					<c:otherwise>
						${i.writerNm}
					</c:otherwise>
				</c:choose>
				<img src="${img}" class="profileImg">
			</td>
			<td>${i.regdt}</td>
		</tr>
	</c:forEach>
</table>
<div id="pagingNum">
	<c:forEach var="i" begin="1" end="${requestScope.maxPage}">
		<c:choose>
			<c:when test="${param.cPage == i || (empty param.cPage && i eq 1)}">
				<span class="colorRed">${i} </span>
			</c:when>
			<c:otherwise>
				<span><a
					href="list?cPage=${i}&searchText=${param.searchText}&searchType=${param.searchType}">${i}</a>
				</span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
<!-- otherwise가 else 같은 애 -->
<div>
	<form action="list" method="get">
		<div>
			<select name="searchType">
				<option value="1" ${param.searchType == 1 ? 'selected' : ''}>제목+내용</option>
				<option value="2" ${param.searchType == 2 ? 'selected' : ''}>제목</option>
				<option value="3" ${param.searchType == 3 ? 'selected' : ''}>내용</option>
				<option value="4" ${param.searchType == 4 ? 'selected' : ''}>글쓴이</option>
			</select> <input type="search" name="searchText" value="${param.searchText}">
			<input type="submit" value="검색">
		</div>
	</form>
</div>