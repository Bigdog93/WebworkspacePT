package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		
		BoardVO vo = Database.getList().get(no);
		
		request.setAttribute("data", vo);
		
		String jspurl = "/WEB-INF/jsp/modify.jsp";
		request.getRequestDispatcher(jspurl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		
		BoardVO vo = Database.getList().get(no);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		response.sendRedirect("/detail?no=" + no);
	}

}
