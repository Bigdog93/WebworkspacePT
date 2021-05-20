package com.koreait.board7.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.koreait.board7.cmt.CmtDAO;
import com.koreait.board7.cmt.CmtVO;


@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!(MyUtils.loginChk(request))) {
			response.sendRedirect("/user/login");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		int loginPK = MyUtils.getLoginUserPk(request);
		BoardVO bvo = new BoardVO();
		bvo.setIboard(iboard);
		bvo.setIuser(loginPK);
		BoardVO result = BoardDAO.selBoard(bvo);
		List<CmtVO> cmtlist = CmtDAO.selCmtList(result);
		request.setAttribute("data", result); // 글의 정보
		request.setAttribute("cmtlist", cmtlist); // 댓글 리스트 정볻
		MyUtils.openJSP("/board/boarddetail", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
