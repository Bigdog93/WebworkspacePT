<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.boardVO.*" %>
<%@ page import="java.util.*" %>
<%
	BoardVO vo = (BoardVO)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div  class = "container">
	<h1>글 수정</h1>
	<form action="/modify" method="post">
		<input type="hidden" name="no" value="<%=vo.getBoard_idx() %>">
		<div>
			제목 : <input type="text" name="title" value="<%=vo.getTitle()%>">
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="20" cols="20"><%=vo.getCtnt() %></textarea>
		</div>
		<input type="submit" value="수정하기">
	</form>
</div>
</body>
</html>