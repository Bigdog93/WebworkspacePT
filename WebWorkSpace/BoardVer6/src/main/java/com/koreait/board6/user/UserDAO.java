package com.koreait.board6.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board6.DBUtils;

public class UserDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	
	public static int joinUser(UserVO param) {
		String sql = "INSERT INTO t_user (uid, upw, unm, gender) VALUES "
				+ "(?, ?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	//로그인 성공:1, 아이디없음:2, 비밀번호틀림:3, 에러:0
	public static int loginUser(UserVO param) {
		String sql = "SELECT uid, upw FROM t_user WHERE "
				+ "uid = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			if(rs.next()) {
				if(!(rs.getString("upw").equals(param.getUpw()))) {
					return 3;
				}
				return 1;
			} else return 2;
		} catch (Exception e) {
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}








