<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<h1>${ data.title }</h1>
	<div>
		${ data.ctnt }
	</div>
	<div>글쓴이 : ${ data.uid }</div>
	<div>작성일시 : ${ data.regdt }</div>
	<c:if test="${loginUser.iuser == data.iuser }">
		<div><a href="modify?iboard=${ data.iboard }&iuser=${data.iuser}"><button>수정</button></a> <a href="delete?iboard=${ data.iboard }&iuser=${data.iuser}"><button>삭제</button></a></div>
	</c:if>
</body>
</html>