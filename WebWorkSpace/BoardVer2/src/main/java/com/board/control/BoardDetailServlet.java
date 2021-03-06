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

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		
//		BoardVO vo = Database.getList().get(no);
		//vo.setView();
		
		BoardDAO bdao = new BoardDAO();
		
		bdao.plus(no, "viewcnt");
		
		BoardVO vo = bdao.selectDetail(no);
		
		request.setAttribute("data", vo);
		
		String url = "/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
