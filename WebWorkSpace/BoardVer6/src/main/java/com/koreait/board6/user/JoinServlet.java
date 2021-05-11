package com.koreait.board6.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board6.MyUtils;


@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request);
		
		String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());
		
		
		System.out.println("hashedUpw : " + hashedUpw);
		
		UserVO uvo = new UserVO(uid, hashedUpw, unm, gender);
		int test = UserDAO.joinUser(uvo);
		
		response.sendRedirect("login");
	}

}