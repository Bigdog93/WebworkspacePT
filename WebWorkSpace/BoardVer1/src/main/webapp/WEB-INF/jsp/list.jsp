<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.board.*" %> 
<!-- 이렇게 하면 자바로 바뀔때 맨 위에 임포트 해준다. -->
    
<%
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("data");
	// getAttribute로 가져올 때도 Object로 가져옴
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table, th, td {
		border : 1px solid black;
		border-collapse : collapse;
	}
</style>
</head>
<body>
	<h1>리스트</h1>
	<div>
		<a href="/write">글쓰기</a> <!-- a태그는 주소창에 치는것과 같은거라 무조건 Get 방식이다. -->
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
			</tr>
				<% for(int i = 0; i < list.size(); i++) { 
					BoardVO vo = list.get(i);%>
				<tr>
					<td><%=i %></td>
					<td>
						<a href="/detail?no=<%=i %>"><%=vo.getTitle() %></a>
						<!-- /* Get방식으로 서버한테 값 전달 할때는 쿼리 스트링으로 전달해야한다.
						 * Post방식으로 서버한테 값 전달 할때는 form태그 사용하여 method를 post로 한 뒤 전달해야함.
						 */ -->
					</td>
				</tr>
				<% } %>
		
		</table>
	</div>
</body>
</html>