package com.koreait.board4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection getCon() throws Exception {
		final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver 설정 안해주면 밑에 URL 보고 톰캣이 알아서 해준데
		final String URL = "jdbc:mysql://localhost:3308/boardver4";  //jdbc:DBMS명://IP주소:포트번호(디폴트3306)/DB명";
		final String USER_NAME = "root";
		final String PASSWORD = "wncks335";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("연결 성공!!");
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null);
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		// con : 다리 역할, ps : 쿼리 실행역할, rs : 셀렉트때만 쓸 결과 담을 것.
		//insert, delete, update 는 영향받은 행 : ? 얘를 int형으로 받을꺼야
		// 열리는 순서 : 1. con, 2. ps, 3. rs 이고,
		// 닫는 순서는 여는 순서의 역행
		if(rs != null) {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		if(ps != null) {
			try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		if(con != null) {
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}
