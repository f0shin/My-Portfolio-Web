package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/favicon.ico")
public class FaviconServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
		
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 타입 설정
        System.out.println("FaviconServlet - /favicon.ico - GET 요청 정상 처리!");
		
        // 아무 작업 없이 빈 응답을 반환 -> Spring의 경고 방지와 같은 역할 수행
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        
    }
    
}

