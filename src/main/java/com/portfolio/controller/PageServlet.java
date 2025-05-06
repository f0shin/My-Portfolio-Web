package com.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.utils.MessageUtil;

@WebServlet({"/", "/home", "/about", "/contact", "/projectList"})
public class PageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 타입 설정
        System.out.println("PageServlet - " + request.getServletPath() + " - GET 요청 정상 처리!");
        
        HttpSession session = request.getSession(); // 세션 가져오기
        String lang = (String) session.getAttribute("lang");
        if (lang == null) { 
            lang = "ja_JP";
        }

        String path = request.getServletPath(); // URL 경로 가져오기
        if ("/".equals(path)) {
            response.sendRedirect("/home"); // 루트 요청을 홈으로 리디렉션
            return;
        }
        
        String cleanPath = path.substring(1);
        String pageTitle = MessageUtil.getMessage("page.name." + cleanPath, null);
        
        String footerMessage1 = MessageUtil.getMessage("footer.message1", lang);
        String footerMessage2 = MessageUtil.getMessage("footer.message2", lang);
        String footerMessage3 = MessageUtil.getMessage("footer.message3", lang);
        
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("pagePath", "/WEB-INF/views/page" + path + ".jsp"); // 해당 페이지 경로 설정
        request.setAttribute("currentLang", lang);

        request.setAttribute("footerMessage1", footerMessage1);
        request.setAttribute("footerMessage2", footerMessage2);
        request.setAttribute("footerMessage3", footerMessage3);
        
        if (cleanPath.equals("home")) {
        	
        	String homeMessage1 = MessageUtil.getMessage("home.message1", lang);
        	String homeMessage2 = MessageUtil.getMessage("home.message2", lang);
        	
        	request.setAttribute("homeMessage1", homeMessage1);
            request.setAttribute("homeMessage2", homeMessage2);

        }
        
        if (cleanPath.equals("about")) {
        	
        	String aboutMessage1 = MessageUtil.getMessage("about.message1", lang);
        	String aboutMessage2 = MessageUtil.getMessage("about.message2", lang);
        	String aboutMessage3 = MessageUtil.getMessage("about.message3", lang);
        	String aboutMessage4 = MessageUtil.getMessage("about.message4", lang);
        	String aboutMessage5 = MessageUtil.getMessage("about.message5", lang);
        	String aboutMessage6 = MessageUtil.getMessage("about.message6", lang);
        	String aboutMessage7 = MessageUtil.getMessage("about.message7", lang);
        	String aboutMessage8 = MessageUtil.getMessage("about.message8", lang);
        	
        	request.setAttribute("aboutMessage1", aboutMessage1);
        	request.setAttribute("aboutMessage2", aboutMessage2);
        	request.setAttribute("aboutMessage3", aboutMessage3);
        	request.setAttribute("aboutMessage4", aboutMessage4);
        	request.setAttribute("aboutMessage5", aboutMessage5);
        	request.setAttribute("aboutMessage6", aboutMessage6);
        	request.setAttribute("aboutMessage7", aboutMessage7);
        	request.setAttribute("aboutMessage8", aboutMessage8);
        	
        }
        

        request.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(request, response);
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
        request.setCharacterEncoding("UTF-8"); // POST 데이터 인코딩 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 타입 설정
        System.out.println("PageServlet - " + request.getServletPath() + " - POST 요청 정상 처리!");
        
    }
    
}




