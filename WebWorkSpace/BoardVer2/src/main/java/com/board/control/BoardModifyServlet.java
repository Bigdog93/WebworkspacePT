package com.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.boardVO.BoardDAO;
import com.board.boardVO.BoardVO;
import com.board.boardVO.Database;

@WebServlet("/modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		
//		request.setAttribute("data", Database.getList().get(no));
		
		BoardDAO bdao = new BoardDAO();
		
		request.setAttribute("data", bdao.selectDetail(no));
		
		String url = "/WEB-INF/jsp/modify.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardDAO bdao = new BoardDAO();
		
//		BoardVO vo = Database.getList().get(no);
		BoardVO vo = new BoardVO(title, ctnt);
		
		bdao.updateBoard(no, vo);
		
		request.setAttribute("data", bdao.selectDetail(no));
		
		response.sendRedirect("/detail?no=" + no);
	}

}
