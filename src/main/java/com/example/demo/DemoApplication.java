package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

        @SuppressWarnings("CallToPrintStackTrace")
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// MySQL 연결 URL, 사용자명, 비밀번호 설정
        String url = "jdbc:postgres://localhost:5432/temp"; // 데이터베이스 URL (mydb는 예시 데이터베이스)
        String user = "postgres";  // MySQL 사용자명
        String password = "1234";  // MySQL 비밀번호

        // SQL 쿼리
        String query = "SELECT * FROM temps"; // 예시로 users 테이블에서 id, name 조회

        // 연결 객체
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.postgres.cj.jdbc.Driver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(url, user, password);

            // SQL 쿼리 실행
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                System.out.println("TEST   " + rs.toString());
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
