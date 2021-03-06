package com.koreait.board4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 오버라이딩 메소드의 경우 throws절도 똑같이 해줘야 한다.
		
		List<BoardVO> list = BoardDAO.selectBoard();
		request.setAttribute("list", list);
		
//		request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
		MyUtils.openJSP("list", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("word");
		
		List<BoardVO> list = BoardDAO.searchBoard(word);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
	}

}
