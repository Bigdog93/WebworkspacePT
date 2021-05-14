package com.koreait.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board7.DBUtils;

public class UserDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;

	public static UserVO selUser(UserVO param) {
		String sql = "SELECT * FROM t_user WHERE uid = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			if (rs.next()) {
				UserVO uvo = new UserVO();
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
	
	public static int insUser(UserVO param) {
		String sql = "INSERT INTO t_user (uid, upw, unm, gender) VALUES (?, ?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
