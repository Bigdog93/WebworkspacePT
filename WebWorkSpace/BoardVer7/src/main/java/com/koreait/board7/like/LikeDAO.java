package com.koreait.board7.like;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.board7.DBUtils;

public class LikeDAO {
	static Connection con;
	static PreparedStatement ps;
	
	public static int insLike(int iboard, int iuser) {
		String sql = "INSERT t_board_like (iboard, iuser) VALUES (?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);
			return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static int delLike(int iboard, int iuser) {
		String sql = "DELETE FROM t_board_like WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);
			return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		}finally {
			DBUtils.close(con, ps);
		}
	}
}
