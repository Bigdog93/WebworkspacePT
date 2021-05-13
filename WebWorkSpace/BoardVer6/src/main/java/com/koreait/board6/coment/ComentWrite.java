package com.koreait.board6.coment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.MyUtils;


@WebServlet("/coment/write")
public class ComentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		String cmt_ctnt = request.getParameter("cmt_ctnt");
		ComentVO cvo = new ComentVO(iboard, iuser, cmt_ctnt);
		int test = ComentDAO.insertCmt(cvo);
		
		response.sendRedirect("/board/detail?iboard="+iboard);
	}

}
