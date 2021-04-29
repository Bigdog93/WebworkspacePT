package com.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.boardVO.BoardDAO;
import com.board.boardVO.Database;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BoardDAO bdao = new BoardDAO();
		
		
		request.setAttribute("database", bdao.selectBoard());
		
		String url = "/WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}