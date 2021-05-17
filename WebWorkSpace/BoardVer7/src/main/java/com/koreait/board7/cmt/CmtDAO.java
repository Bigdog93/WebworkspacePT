package com.koreait.board7.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;
import com.koreait.board7.board.BoardVO;

public class CmtDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static int insCmt(CmtVO param) {
		String sql = "INSERT INTO t_board_cmt (iuser, iboard, cmt) VALUES (?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());
			ps.setInt(2, param.getIboard());
			ps.setString(3, param.getCmt());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	public static List<CmtVO> selCmtList(BoardVO param) {
		String sql = "SELECT A.*, B.uid FROM t_board_cmt A LEFT JOIN t_user B ON A.iuser = B.iuser WHERE iboard = ?";
		List<CmtVO> cmtlist = new ArrayList<CmtVO>();
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			while(rs.next()) {
				CmtVO cvo = new CmtVO();
				cvo.setIcmt(rs.getInt("icmt"));
				cvo.setCmt(rs.getString("cmt"));
				cvo.setDislike(rs.getInt("dislike"));
				cvo.setLikecnt(rs.getInt("likecnt"));
				cvo.setRegdt(rs.getString("regdt"));
				cvo.setUid(rs.getString("uid"));
				cvo.setIuser(rs.getInt("iuser"));
				cmtlist.add(cvo);
			}
			return cmtlist;
		} catch (Exception e) {
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int delCmt(CmtVO cvo) {
		String sql = "DELETE FROM t_board_cmt WHERE icmt = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cvo.getIcmt());
			ps.setInt(2, cvo.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
