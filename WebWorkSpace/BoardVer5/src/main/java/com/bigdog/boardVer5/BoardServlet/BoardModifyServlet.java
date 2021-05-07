package com.bigdog.boardVer5.BoardServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdog.boardVer5.BoardDAO.BoardDAO;
import com.bigdog.boardVer5.BoardDAO.BoardVO;


@WebServlet("/modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("iboard");
		int iboard = Integer.parseInt(strNo);
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo = BoardDAO.selBoard(vo);
		
		
		request.setAttribute("data", vo);
		
		String jsp = "/WEB-INF/jsp/modify.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("iboard");
		int iboard = Integer.parseInt(strNo);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		BoardVO vo = new BoardVO(iboard, title, ctnt);
		
		int test = BoardDAO.modifyBoard(vo);
		System.out.println(test);
		
		response.sendRedirect("/detail?iboard=" + iboard);
	}

}
