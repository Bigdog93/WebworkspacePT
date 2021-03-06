<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.koreait.board.*" %> 
    
<%
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("data"); // 이렇게 전체를 받아오는거 보다,
	// getAttribute로 가져올 때도 Object로 가져옴
	BoardVO vo = (BoardVO) request.getAttribute("vo");					// 이렇게 서블릿에서 걸러서 가져다 주는게 나을꺼 같다..
	// 저기 멀리 HTML(브라우저)에서 부터 오는건 getParameter로 받는다 (set이 없다)
	// 서블릿에 (내가 set으로)담은거 가져올때는 getAttribute로 받아온다.
	// 서블릿에 담을때는 setAttribute로 담는다.
	
	// get으로 요청하는건 리터럴 아니면 주소값이다.
	
	/*
	request.getParameter("키"); -> HTML로 부터 온 값(쿼리스트링, 태그의 name속성 등으로)을 받을때 쓴다.
	(String 방식) (물론 한값만 담긴다)(String타입이기 때문에 객체주소값은 보낼 수 없다)
	
	
	request.setAttribute("키", value); -> 데이터베이스 등으로부터 자료를 빼내어 담을때 쓴다. (역시 value에는 한값만 담긴다)
	request.getAttribute("키"); -> set으로 담은 Attribute에서 "키"값을 통해 value 값을 빼내어 온다.(Object방식)
	*/
	
	// getParameter는 String형으로 받고
	// getAttribute는 Object형으로 받는다.
	
	String str = request.getParameter("no");
	// 서블릿의 request나 여기의 request나 같은놈. (서블릿에서 forward메소드로 request, reponse를 다 넘겨주기 때문. 그놈이 그놈)
	
	int no = Integer.parseInt(str);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>디테일</h1>
	<!-- 나중에 EL식이란 걸로 쓰면 스크립트릿 안써도 된다링 -->
	<%=request.getParameter("no") %> <!-- 이렇게 적는걸 표현식이라 한다. -->
	<div>
		<%-- <form action="/delete" method="post"> <!-- post방식으로 만들때 -->
			<input type="hidden" name="no" value="<%=no %>">
			<input type="submit" value="삭제">	
		</form> --%>
	</div>
	<a href="/modify?no=<%=no %>"><button>수정</button></a>
	<a href="/delete?no=<%=no %>"><button>삭제</button></a> <!-- get방식으로 보낼때 -->
	<h2>제목 : <%=vo.getTitle() %></h2>
	<p>내용 : <%=vo.getCtnt() %></p>
	<a href="/list"><button>목록</button></a>
</body>
</html>