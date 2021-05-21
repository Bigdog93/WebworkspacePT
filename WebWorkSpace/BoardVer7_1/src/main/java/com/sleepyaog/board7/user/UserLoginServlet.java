package com.sleepyaog.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.sleepyaog.board7.common.MyUtils;


@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/login", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		UserVO uvo = new UserVO();
		uvo.setUid(uid);
		UserVO result = UserDAO.selUser(uvo);
		String errMsg = null;
		if(result != null) {
			if(BCrypt.checkpw(upw, result.getUpw())) {
				response.sendRedirect("/board/list");
				return;
			}else {
				errMsg = "PW is not found";
			}
		}else {
			errMsg = "ID is not found";
		}
		request.setAttribute("err", errMsg);
		doGet(request, response);
	}

}
