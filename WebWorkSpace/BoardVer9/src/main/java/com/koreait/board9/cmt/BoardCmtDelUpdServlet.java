package com.koreait.board9.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board9.MyUtils;


@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//댓글 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int loginUserPk = MyUtils.getLoginUserPk(request);
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setIuser(loginUserPk);
		int result = BoardCmtDAO.delBoardCmt(param);
		
		String json = "{\"result\":" + result + "}";
		response.getWriter().append(json);
		
		
	}

	//댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		String cmt = request.getParameter("cmt");
		int loginUserPk = MyUtils.getLoginUserPk(request);
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setCmt(cmt);
		param.setIuser(loginUserPk);
		int result = BoardCmtDAO.modBoardCmt(param);
		
		String json = "{\"result\":" + result + "}";
		response.getWriter().append(json);
	}

}
