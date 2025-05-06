package com.portfolio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// 배포시
//	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private static final String USER = "portfolio_admin";
//	private static final String PASSWORD = "p5rtfolio@admin";
	
	// 인메모리 DB
	private static final String JDBC_DRIVER = "org.h2.Driver";
//	private static final String URL = "jdbc:h2:mem:testdb"; // 서버 종료시 데이터 날라감.
	private static final String URL = "jdbc:h2:file:C:/dev/db/testdb;TRACE_LEVEL_FILE=0"; // 서버 종료해도 파일로 보존.
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (SQLException se) {
			System.err.println("❌ DB 연결 실패: ");
			se.printStackTrace();
		}

		System.out.println("✅ DB 연결 성공! " + connection.getMetaData().getURL());

		return connection;
	}

}
