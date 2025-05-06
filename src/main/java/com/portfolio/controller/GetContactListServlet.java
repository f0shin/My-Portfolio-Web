package com.portfolio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.model.Contact;
import com.portfolio.service.ContactService;
import com.portfolio.utils.MessageUtil;

@WebServlet("/admin/getContactList")
public class GetContactListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactService contactService = new ContactService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); // 응답 데이터 인코딩 설정
		response.setContentType("text/html;charset=UTF-8"); // 응답 타입과 인코딩 설정
		System.out.println("GetContactListServlet - /admin/getContactList - GET 요청 정상 처리!");

		List<Contact> contacts = contactService.getAllContacts(); // 모든 문의 목록 조회
		request.setAttribute("contacts", contacts); // JSP에 데이터 전달
		
		HttpSession session = request.getSession();
		String lang = (String) session.getAttribute("lang");
        if (lang == null) { 
            lang = "ja_JP";
        }
        
        String pageTitle = "Admin Page";

        String footerMessage1 = MessageUtil.getMessage("footer.message1", lang);
        String footerMessage2 = MessageUtil.getMessage("footer.message2", lang);
        String footerMessage3 = MessageUtil.getMessage("footer.message3", lang);
        
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("pagePath", "/WEB-INF/views/page/admin.jsp"); // 해당 페이지 경로 설정
        request.setAttribute("currentLang", lang);

        request.setAttribute("footerMessage1", footerMessage1);
        request.setAttribute("footerMessage2", footerMessage2);
        request.setAttribute("footerMessage3", footerMessage3);
        
        String alertType = "";
		String alertMessage = "";
		
		request.getSession().setAttribute("alertType", alertType);
        request.getSession().setAttribute("alertMessage", alertMessage);
		
		alertType = "success";
		alertMessage = "Login Sucuccess!😊";

        request.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(request, response);
        
	}

}
