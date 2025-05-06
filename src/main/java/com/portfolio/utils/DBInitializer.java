package com.portfolio.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {
    public static void initializeDatabase() {
        try (Connection conn = DBConnection.getConnection(); // ✅ DBConnection 활용
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
                         "id VARCHAR(36) PRIMARY KEY, " +
                         "name VARCHAR(100) NOT NULL, " +
                         "email VARCHAR(100) NOT NULL, " +
                         "message TEXT NOT NULL, " +
                         "completed INT DEFAULT 0, " +
                         "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

            stmt.execute(sql);
            conn.setAutoCommit(true); // 자동 커밋 활성화

            System.out.println("✅ 테이블 생성 완료! 🎉");

        } catch (SQLException e) {
            System.err.println("❌ 테이블 생성 실패:");
            e.printStackTrace();
        }
    }
}
