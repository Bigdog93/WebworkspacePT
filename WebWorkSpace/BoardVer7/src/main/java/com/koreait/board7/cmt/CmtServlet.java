package com.koreait.board7.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPk(request);
		CmtVO cvo = new CmtVO();
		cvo.setIcmt(icmt);
		cvo.setIuser(iuser);
		CmtDAO.delCmt(cvo);
		
		response.sendRedirect("detail?iboard=" + iboard);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPk(request);
		CmtVO cvo = new CmtVO(iuser, iboard, cmt);
		int test = CmtDAO.insCmt(cvo);
		response.sendRedirect("detail?iboard=" + iboard);
	}
	
}
