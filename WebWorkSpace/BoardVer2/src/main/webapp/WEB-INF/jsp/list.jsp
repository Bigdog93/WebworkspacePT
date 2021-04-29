<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.boardVO.*"%>
<%@ page import="java.util.* " %>
<%
	List<BoardVO> db = (List<BoardVO>)request.getAttribute("database");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div class = "container">
	<h1>의미없는 게시판</h1>
	<div id="write"><a href="/write"> 글쓰기</a></div>
	<div class="boardlist">
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>조회수</th>
				<th>추천</th>
				<th>반대</th>
			</tr>
			<% for(int i = 0; i < db.size(); i++) { %>
			<tr>
				<td><%=db.get(i).getBoard_idx() %></td>
				<td><a href="/detail?no=<%=db.get(i).getBoard_idx() %>"><%=db.get(i).getTitle() %></a></td>
				<td><%=db.get(i).getView() %></td>
				<td><%=db.get(i).getLike() %></td>
				<td><%=db.get(i).getDislike() %></td>
			<tr>
			<% } %>
		</table>
	</div>
</div>
</body>
</html>