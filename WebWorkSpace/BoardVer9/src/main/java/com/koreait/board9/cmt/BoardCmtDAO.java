package com.koreait.board9.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board9.DBUtils;

public class BoardCmtDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static int insBoardCmt(BoardCmtEntity param) {
		int result = 0;
		String sql = "INSERT INTO t_board_cmt "
				+ "(iboard, iuser, cmt) "
				+ "VALUES "
				+ "	(?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtils.close(con, ps);
		}
		
		return result;
	}
	
	public static List<BoardCmtDomain> selBoardCmtList(BoardCmtEntity param) {
		List<BoardCmtDomain> cmtList = new ArrayList<BoardCmtDomain>();
		String sql = "SELECT A.icmt, A.cmt, A.regdt, B.iuser, B.unm AS writerNm "
				+ "FROM t_board_cmt A "
				+ "LEFT JOIN t_user B "
				+ "ON A.iuser = B.iuser "
				+ "WHERE A.iboard = ? "
				+ "ORDER BY A.icmt ASC";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardCmtDomain cmtvo = new BoardCmtDomain();
				cmtvo.setCmt(rs.getString("cmt"));
				cmtvo.setIcmt(rs.getInt("icmt"));
				cmtvo.setRegdt(rs.getString("regdt"));
				cmtvo.setIuser(rs.getInt("iuser"));
				cmtvo.setWriterNm(rs.getString("writerNm"));
				cmtList.add(cmtvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return cmtList;
	}
	
	public static int delBoardCmt(BoardCmtEntity param) {
		String sql = "DELETE FROM t_board_cmt WHERE icmt = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static int modBoardCmt(BoardCmtEntity param) {
		String sql = "UPDATE t_board_cmt "
				+ "SET cmt = ? "
				+ "WHERE icmt = ? AND iuser = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getCmt());
			ps.setInt(2, param.getIcmt());
			ps.setInt(3, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
