package com.sleepyaog.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sleepyaog.board7.common.DBUtils;

public class UserDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static int insUser(UserVO param) {
		String sql = "INSERT INTO t_user (uid, upw, unm, gender, ph) VALUES (?, ?, ?, ?, ?)";
		try {
			con = DBUtils.Getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setString(4, param.getGender());
			ps.setString(5, param.getPh());
			return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static UserVO selUser(UserVO param) {
		String sql = "SELECT * FROM t_user WHERE uid = ?";
		UserVO uvo = null;
		try {
			con = DBUtils.Getcon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			if(rs.next()) {
				uvo = new UserVO();
				uvo.setIuser(rs.getInt("iuser"));
				uvo.setUid(rs.getString("uid"));
				uvo.setUpw(rs.getNString("upw"));
				uvo.setUnm(rs.getString("unm"));
				uvo.setGender(rs.getString("gender"));
				uvo.setPh(rs.getString("ph"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return uvo;
	}
}
