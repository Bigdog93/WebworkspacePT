package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/comentDelete")
public class ComentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String icmt_str = request.getParameter("icmt");
		int icmt = Integer.parseInt(icmt_str);
		String iboard = request.getParameter("no");
		
		CmtVO cvo = new CmtVO();
		cvo.setIcmt(icmt);
		
		int test = BoardDAO.cmtDelete(cvo);
		
		response.sendRedirect("/detail?no=" + iboard);
	}

}
