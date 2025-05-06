package com.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.service.ContactService;

@WebServlet("/saveContact")
public class SaveContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactService contactService = new ContactService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩 설정
		response.setContentType("text/html;charset=UTF-8"); // 응답 타입과 인코딩 설정
		System.out.println("SaveContactServlet - /saveContact - POST 요청 정상 처리!");

		// 요청 데이터 받아오기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		String alertType = "";
		String alertMessage = "";

		try {
			contactService.saveContact(name, email, message); // Service를 통해 데이터 저장

			alertType = "success";
			alertMessage = "Send Contact Success !! 😊";

		} catch (Exception e) {
			e.printStackTrace();

			alertType = "error";
			alertMessage = "Send Contact Error ..😭";

		}
		
		request.getSession().setAttribute("alertType", alertType);
        request.getSession().setAttribute("alertMessage", alertMessage);

        response.sendRedirect("/contact");

	}

}
