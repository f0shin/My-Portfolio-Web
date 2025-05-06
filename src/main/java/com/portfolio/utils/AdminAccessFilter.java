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

        // 로그인 확인
        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect("/login"); // 로그인되지 않으면 리다이렉트
            return;
        }

        chain.doFilter(request, response); // 정상적인 경우 필터 통과
    }

    // 필터 종료 처리
    @Override
    public void destroy() {
    	System.out.println("AdminAccessFilter - /admin/* - Destroy");
    }
}
