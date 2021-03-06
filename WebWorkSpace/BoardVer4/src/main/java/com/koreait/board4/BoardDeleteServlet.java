package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no = Integer.parseInt(strNo);

		BoardVO param = new BoardVO();
		param.setIboard(no);
		BoardDAO.deleteBoard(param);
		// 이렇게 짜면(vo에 담아 보내면) 더 유연한 코드가 된다.
		// 보낼 값이 2개 이상이 되어도 DAO에 선언부를 건들지 않아도 된다.
		
//		int test = BoardDAO.deleteBoard(no);
		
		
		response.sendRedirect("/list");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
