package com.koreait.board9.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board9.DBUtils;

public class UserDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static int selIdChk(String uid) {
		String sql = "SELECT uid FROM t_user WHERE uid = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			if(rs.next()) return 1;
			return 0;
		} catch (Exception e) {
			return 1;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static UserEntity selUser(UserEntity param) {
		String sql = "SELECT * FROM t_user WHERE uid = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			if (rs.next()) {
				UserEntity uvo = new UserEntity();
				uvo.setUnm(rs.getString("unm"));
				uvo.setIuser(rs.getInt("iuser"));
				uvo.setUid(param.getUid());
				uvo.setUpw(rs.getString("upw"));
				return uvo;
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
}
