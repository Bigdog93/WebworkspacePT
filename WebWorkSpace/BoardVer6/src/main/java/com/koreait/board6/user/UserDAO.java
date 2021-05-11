package com.koreait.board6.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

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
		String sql = "SELECT iuser, uid, upw, unm FROM t_user WHERE "
				+ "uid = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			if(rs.next()) {
				// 아이디가 있을 경우
//				if(rs.getString("upw").equals(param.getUpw())) {
				if(BCrypt.checkpw(param.getUpw(), rs.getString("upw"))) { // 암호화된 값을 비교하는 법
					// checkpw(평문, digest) 같으면 true, 다르면 false
					// 비밀번호도 있을 경우
					param.setIuser(rs.getInt("iuser"));
					param.setUnm(rs.getString("unm"));
					return 1;
				}
				// 비밀번호가 틀렸을 경우
				return 3;
			} else return 2; // 아이디가 없을 경우
		} catch (Exception e) {
			return 0; // 오류
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}








