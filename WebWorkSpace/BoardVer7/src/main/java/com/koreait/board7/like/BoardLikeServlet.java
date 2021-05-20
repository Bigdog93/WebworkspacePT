package com.koreait.board7.like;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/like")
public class BoardLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int like = MyUtils.getParamInt("like", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		switch(like) {
		case 0: // 좋아요 취소
			LikeDAO.delLike(iboard, iuser);
			break;
		case 1:
			LikeDAO.insLike(iboard, iuser);
			break;
		}
		
		response.sendRedirect("/board/detail?iboard=" + iboard);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
