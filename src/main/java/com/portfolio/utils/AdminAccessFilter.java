package com.portfolio.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminAccessFilter implements Filter {
	
	// 필터 초기화
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AdminAccessFilter - /admin/* - Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        
//        session.setAttribute("user", "test"); // admin이 아닌 경우 테스트

        // 로그인 확인
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("AdminAccessFilter - /admin/* - ❌ no login");
            res.sendRedirect("/login"); // 로그인 되어있지 않으면 /login 리다이렉트
            return;
        } else if (!session.getAttribute("user").equals("admin")) {
        	System.out.println("AdminAccessFilter - /admin/* - ❌ no admin");
        	res.sendRedirect("/home"); // admin이 아니면 /home 리다이렉트 (나중을 위해!)
        	return;
        } else {
        	System.out.println("AdminAccessFilter - /admin/* - ✅ admin");
        }

        chain.doFilter(request, response); // 정상적인 경우 필터 통과
    }

    // 필터 종료 처리
    @Override
    public void destroy() {
    	System.out.println("AdminAccessFilter - /admin/* - Destroy");
    }
}
