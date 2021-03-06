package com.koreait.board9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board9.user.UserEntity;

public class MyUtils {
	
	public static boolean loginChk(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute(Const.LOGINUSER) == null) {
			return false;
		}
		return true;
	}
	
	public static int getLoginUserPk(HttpServletRequest request) {
		return getLoginUser(request).getIuser();
	}
	
	public static UserEntity getLoginUser(HttpServletRequest request) {
		if(request == null) {return null;}
		HttpSession session = request.getSession();
		String user = "loginUser";
		return (UserEntity)session.getAttribute(user);
	}
	
//	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String jsp = String.format("/WEB-INF/view/%s.jsp", fileNm);
//		request.getRequestDispatcher(jsp).forward(request, response);
//	}
	
	public static void openJSP(String title, String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/view/template.jsp";
		request.setAttribute(Const.TITLE, title);
		request.setAttribute(Const.PAGE, page);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	public static int parseStringToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest request) {
		return parseStringToInt(request.getParameter(key));
	}
	
}
