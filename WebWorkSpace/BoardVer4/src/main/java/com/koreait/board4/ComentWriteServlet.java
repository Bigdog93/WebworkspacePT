package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/comentWrite")
public class ComentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard_str = request.getParameter("iboard");
		int iboard = Integer.parseInt(iboard_str);
		String cmtID = request.getParameter("cmtID");
		String cmt = request.getParameter("cmt");
		
		CmtVO cvo = new CmtVO(iboard, cmtID, cmt);
		
		BoardDAO.cmtWrite(cvo);
		
		response.sendRedirect("/detail?no="+iboard);
	}

}
