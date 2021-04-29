package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Get방식으로 서버한테 값 전달 할때는 쿼리 스트링으로 전달해야한다.
		 * Post방식으로 서버한테 값 전달 할때는 form태그 사용하여 method를 post로 한 뒤 전달해야함.
		 * 
		 */
		request.setAttribute("data", Database.getlist());
		
		
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		System.out.println("no : " + no);
		request.setAttribute("vo", Database.getlist().get(no));
		// ArrayList의 주요 메소드
		// .get(인덱스(정수형))
		// .add(넣을값(제네릭))
		// .size()
		
		// Map형식 : 순서가 없이 키:밸류 형태로 들어가는 형식
		// sequence형식 : 배열, ArrayList와 같이 순서가 있는(index) 형식
		// LinkedList : 배열과 같으나 실제 물리적으로가 아니라 논리적으로 이어져있음
		
		String url = "/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
