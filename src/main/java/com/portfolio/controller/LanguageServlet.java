package com.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/changeLang")
public class LanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 타입 설정
        System.out.println("LanguageServlet - /changeLang - GET 요청 정상 처리!");
        
        HttpSession session = request.getSession(); // 세션 가져오기
        String lang = request.getParameter("lang");
        
        if (lang != null) {
            session.setAttribute("lang", lang);
            response.getWriter().write("언어 변경 완료!!");
        }

        // 사용자가 있던 페이지로 이동 (홈으로 리디렉션하지 않음)
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer != null ? referer : "/home");
        
    }
	
    
}

