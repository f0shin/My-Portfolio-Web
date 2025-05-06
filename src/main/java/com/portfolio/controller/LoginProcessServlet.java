package com.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginSubmit")
public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩 설정
		response.setContentType("text/html;charset=UTF-8"); // 응답 타입과 인코딩 설정
		System.out.println("LoginProcessServlet - /loginSubmit - POST 요청 정상 처리!<br>");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String alertType = "";
		String alertMessage = "";

		if ("admin".equals(id) && "1234".equals(pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", id);
			
			alertType = "success";
			alertMessage = "Login Success !!😊";
			
			request.getSession().setAttribute("alertType", alertType);
	        request.getSession().setAttribute("alertMessage", alertMessage);
			
			response.sendRedirect("/admin"); // 로그인 성공 시 admin.jsp로 이동
			
		} else {
			
			alertType = "error";
			alertMessage = "Retry ... 😭";
			
			request.getSession().setAttribute("alertType", alertType);
	        request.getSession().setAttribute("alertMessage", alertMessage);
			
			response.sendRedirect("/login"); // 로그인 실패 시 다시 로그인하라는 의미로 login.jsp로 이동
		}
		
	}
}
