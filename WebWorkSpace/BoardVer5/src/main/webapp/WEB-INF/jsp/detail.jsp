<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table, th, td {
	border : 1px solid black;
	border-collapse: collapse;
}
</style>
<title>글 보기</title>
</head>
<body>
	<div>
		<a href="/modify?iboard=${ param.iboard }"><button>수정</button></a> 
		<a href="/delete?iboard=${ param.iboard }"><button>삭제</button></a>
	</div>
	<div>
		<h1>${ data.title }</h1>
	</div>
	<p>${ data.ctnt }</p>
	
	<form action="/boardlike" method="post">
		<input type="hidden" name = "iboard" value="${param.iboard}">
		<input type="submit" value="추천 ${ data.likecnt }">
	</form>
	<a href="/boardlike?iboard=${param.iboard}"><button>반대 ${ data.dislike }</button></a>

	<a href="/list"><button>글목록</button></a>
	<div>
		<form action="/detail" method="post">
			<input type="hidden" name="iboard" value="${ param.iboard }">
			댓글 쓰기 : <input type="text" name="cmt"> ID : <input
				type="text" name="cmtID"><input type="submit" value="댓글작성">
		</form>
	</div>
	<div>
		<table>
			<c:forEach var="i" items="${cmt_list}">
				<tr>
					<td>${ i.cmtID }</td>
					<td>${ i.cmt }</td>
					<td><a
						href="/cmtlike?iboard=${ param.iboard }&icmt=${ i.icmt }&like=true">추천
							: ${ i.likecnt }</a></td>
					<td><a
						href="/cmtlike?iboard=${ param.iboard }&icmt=${ i.icmt }&like=false">반대
							: ${ i.dislike }</a></td>
					<td>${ i.cmt_regdt }</td>
					<td><a
						href="/cmtdelete?iboard=${ param.iboard }&icmt=${ i.icmt }"><button>삭제</button></a>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>