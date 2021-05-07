package com.bigdog.boardVer5.BoardServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdog.boardVer5.BoardDAO.BoardDAO;
import com.bigdog.boardVer5.BoardDAO.ComentVO;


@WebServlet("/cmtlike")
public class ComentLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("icmt");
		int icmt = Integer.parseInt(strNo);
		String like = request.getParameter("like");
		boolean islike = false;
		if(like.equals("true")) {
			islike = true;
		}
		ComentVO cvo = new ComentVO(icmt);
		BoardDAO.likeComent(cvo, islike);
		
		
		String iboard = request.getParameter("iboard");
		response.sendRedirect("/detail?iboard=" + iboard);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
