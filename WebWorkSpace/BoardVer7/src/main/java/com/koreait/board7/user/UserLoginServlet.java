package com.koreait.board7.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board7.MyUtils;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginUser");
		if(uvo != null) {
			response.sendRedirect("/board/list");
			return;
		}
		MyUtils.openJSP("user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		UserVO uvo = new UserVO();
		uvo.setUid(uid);
		uvo.setUpw(upw);
		UserVO result = UserDAO.selUser(uvo);
		if(result == null) {
			request.setAttribute("errMsg", "아이디를 확인해주세요");
		} else if(BCrypt.checkpw(uvo.getUpw(), result.getUpw())) {
			result.setUpw(null);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");
			return;
		} else {
			request.setAttribute("errMsg", "비밀번호 확인");
		}

		doGet(request, response);
	}

}
