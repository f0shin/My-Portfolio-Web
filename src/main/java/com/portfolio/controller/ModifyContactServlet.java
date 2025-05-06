package com.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.service.ContactService;

@WebServlet("/admin/modifyContact")
public class ModifyContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactService contactService = new ContactService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); // 응답 인코딩 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 타입 설정
        System.out.println("ModifyContactServlet - /admin/modifyContact - GET 요청 정상 처리!");
        
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩 설정
		response.setContentType("text/html;charset=UTF-8"); // 응답 타입과 인코딩 설정
		System.out.println("ModifyContactServlet - /admin/modifyContact - POST 요청 정상 처리!");
		
		// 요청 데이터 받아오기
		String contactId = request.getParameter("id");
		
		String alertType = "";
		String alertMessage = "";
		
		try {
			contactService.modifyContactCompleted(contactId, 1); // Service를 통해 데이터 저장

			alertType = "success";
			alertMessage = "Modify Success!😊";

		} catch (Exception e) {
			e.printStackTrace();

			alertType = "error";
			alertMessage = "Modify Error..😭";

		}
		
		request.getSession().setAttribute("alertType", alertType);
        request.getSession().setAttribute("alertMessage", alertMessage);

        response.sendRedirect("/admin"); // 완료 후 다시 목록 페이지로 이동
    }

}
