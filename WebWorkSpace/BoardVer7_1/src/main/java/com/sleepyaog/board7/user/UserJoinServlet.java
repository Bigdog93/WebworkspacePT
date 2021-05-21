package com.sleepyaog.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.sleepyaog.board7.common.MyUtils;


@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String unhasgedUpw = request.getParameter("upw");
		String upw = BCrypt.hashpw(unhasgedUpw, BCrypt.gensalt());
		String unm = request.getParameter("unm");
		String gender = request.getParameter("gender");
		String ph = request.getParameter("ph");
		
		UserVO uvo = new UserVO(uid, upw, unm, gender, ph);
		int test = UserDAO.insUser(uvo);
		
		response.sendRedirect("/user/login");
	}

}
