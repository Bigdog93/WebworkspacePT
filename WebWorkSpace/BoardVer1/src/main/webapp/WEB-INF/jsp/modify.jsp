<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.board.*" %> 
<%
	BoardVO vo = (BoardVO)request.getAttribute("board");
	int no = Integer.parseInt(request.getParameter("no"));
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="/modify" method="post">
		<input type="hidden" name="no" value="<%=no %>">
		<div>
			제목 : <input type="text" name="title" value="<%=vo.getTitle() %>">
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10"><%=vo.getCtnt() %></textarea>
		</div>
		<div>
			<input type="submit" value="글수정"> 
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>