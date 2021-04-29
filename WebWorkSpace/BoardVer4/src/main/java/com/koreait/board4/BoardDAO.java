package com.koreait.board4;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Data Access Object(DB 담당)
public class BoardDAO {

	//글 등록
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title, ctnt) VALUES (?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
