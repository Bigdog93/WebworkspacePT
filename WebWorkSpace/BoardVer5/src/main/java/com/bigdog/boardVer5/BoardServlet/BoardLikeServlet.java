package com.bigdog.boardVer5.BoardServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdog.boardVer5.BoardDAO.BoardDAO;
import com.bigdog.boardVer5.BoardDAO.BoardVO;


@WebServlet("/boardlike")
public class BoardLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("iboard");
		int iboard = Integer.parseInt(strNo);
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		int test = BoardDAO.likeBoard(vo, false);
		
		response.sendRedirect("/rdetail?iboard=" + iboard);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("iboard");
		int iboard = Integer.parseInt(strNo);
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		int test = BoardDAO.likeBoard(vo, true);
		
		response.sendRedirect("/rdetail?iboard=" + iboard);
	}

}
