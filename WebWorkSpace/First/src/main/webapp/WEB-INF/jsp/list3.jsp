<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// jsp 파일은 자바 파일로 바뀌는데 그때 이 문서 전체가 _jspService 메소드 안으로 들어가는데 그때 매개변수 중 request 와 reponse가 있다. 거기다가 전달 받은 request를 
// 받기 때문에 여기서 request 를 그대로 쓸 수 있음.
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>화면</h1>
	<%=name %>, <%=age %>
</body>
</html>