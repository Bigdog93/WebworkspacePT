package com.bigdog.boardVer5.BoardServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdog.boardVer5.BoardDAO.BoardDAO;
import com.bigdog.boardVer5.BoardDAO.ComentVO;


@WebServlet("/cmtdelete")
public class ComentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("icmt");
		int icmt = Integer.parseInt(strNo);
		strNo = request.getParameter("iboard");
		
		ComentVO cvo = new ComentVO(icmt);
		int test = BoardDAO.deleteComent(cvo);
		
		response.sendRedirect("/detail?iboard="+strNo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
