package com.koreait.board;
/*
클라이언트(브라우저) 값이 서버쪽으로 넘어왔음....
<값 빼내는 방법>
request.getParameter(키값);
--------------------------------
서블릿에서 jsp로 값 전달하는 방법
<값 넣는 방법>
request.setAttribute(키, 밸류);

<값 빼는 방법>
request.getAttribute(키값);
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list") // 클래스 이름따위는 하나도 안중요하고
// @어노테이션 뒤에 들어간 이 URL이 중요하다.!!
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.jsp 파일을 열꺼얌
		// 위 URL로 get 방식으로 요청이 들어오면 실행되는 메소드. Get 방식은 대부분 화면 띄우기용.(거의 jsp 파일을 연다고 보면 된다.)
		
//		String jsp = "/WEB-INF/jsp/list.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(jsp);
//		rd.forward(request, response);
		
		request.setAttribute("data", Database.getlist());
		// 이렇게 setAttribute 쓰면 뒤에 인자는 Object 타입으로 들어간다.
		
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
