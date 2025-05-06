package com.portfolio.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.portfolio.utils.DBInitializer;

@WebListener
public class DBInitializerListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("🔹 애플리케이션 시작: DB 초기화 진행...");
        DBInitializer.initializeDatabase();
        System.out.println("✅ DB 초기화 완료!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("🔹 애플리케이션 종료: 정리 작업 진행...");
    }
}
