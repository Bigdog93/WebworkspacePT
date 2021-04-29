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
	<h1>디테일</h1>
	<div>
		<a href="/modify?no=<%=vo.getBoard_idx() %>"><button>수정</button></a>
		<a href="/delete?no=<%=vo.getBoard_idx() %>"><button>삭제</button></a>
	</div>
	<h2>제목 : <%=vo.getTitle() %> | <%=vo.getView() %></h2>
	<p><%=vo.getCtnt() %></p>
	<a href="/like?no=<%=vo.getBoard_idx()%>"><button>좋아요 : <%=vo.getLike() %></button></a>
	<form action="/like" method="post">
		<input type="hidden" name="no" value="<%=vo.getBoard_idx() %>">
		<input type="submit" value="싫어요 : <%=vo.getDislike() %>">
	</form>
	<a href="/list"><button>목록</button></a>
</div>
</body>
</html>