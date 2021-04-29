<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "홍길동";
	pageContext.setAttribute("name", "심사임당");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/list">돌아가기</a>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.getCtnt()}</div>
	<%-- 
	!!!! EL식 !!!!
	data : 서블렛에서 setAttribute로 줄때 설정한 key값
	그럼 key값에 저장된 value값이 오고, 
	value가 객체주소값이라면 .으로 
	그 주소값 객체의 필드에 접근할 수 있다.
	title로 하면 알아서 getTitle() 메소드로 가져와준다. 이때 제너레이터를 이용하지 않고 멋대로 만들면
	호출이 안된다..!!
	또는 직접 .getTitle()로 넣어줘도 됨.
	
	즉, EL식은 (형변환)request(또는 다른 내장객체).getAttribute("key").getter
	getParameter는
	${param.name=""으로 준 키값} 으로 쿼리스트링으로 온 것도 받을 수 있다.
	
	내장객체별 key값이 중복되면, 가장 명이 짧은 애꺼 쓴다.
	ex )
		pageContext.setAttribute("key", "A");
		request.setAttribute("key", "B");
		session.setAttribute("key", "C");
		application.setAttribute("key", "D");
		일때,
		${key} 하면 A가 찍힌다.
		그러나!!
		${requestContext.key} 이런 식으로 하면 B가 나온다.
	 --%>
	 <a href="/delete?no=${ param.no }"><button>삭제</button></a>
	 <a href="/modify?no=${ param.no }"><button>수정</button></a>
	 <hr>
	 <div>쿼리스트링 ${param.no}</div>
	 <div>String name : <%=name %></div>
	 <div>내장객체 : ${name}</div>
</body>
</html>