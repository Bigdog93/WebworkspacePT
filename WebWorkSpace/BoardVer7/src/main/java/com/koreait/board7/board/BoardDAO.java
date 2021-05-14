package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static List<BoardVO> selBoardList() {
		String sql = "SELECT A.*, B.uid FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser ORDER BY iboard DESC";
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setCtnt(rs.getString("ctnt"));
				bvo.setDislike(rs.getInt("dislike"));
				bvo.setIboard(rs.getInt("iboard"));
				bvo.setIuser(rs.getInt("iuser"));
				bvo.setLikecnt(rs.getInt("likecnt"));
				bvo.setRegdt(rs.getString("regdt"));
				bvo.setTitle(rs.getString("title"));
				bvo.setViewcnt(rs.getInt("viewcnt"));
				boardlist.add(bvo);
			}
			return boardlist;
		} catch (Exception e) {
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int insBoard(BoardVO param) {
		String sql = "INSERT INTO t_board (iuser, title, ctnt) VALUES (?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());
			ps.setString(2, param.getTitle());
			ps.setString(3, param.getCtnt());
			return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static BoardVO selBoard(BoardVO param) {
		String sql = "SELECT A.*, B.uid FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			if(rs.next()) {
				param.setCtnt(rs.getString("ctnt"));
				param.setDislike(rs.getInt("dislike"));
				param.setIuser(rs.getInt("iuser"));
				param.setLikecnt(rs.getInt("likecnt"));
				param.setRegdt(rs.getString("regdt"));
				param.setTitle(rs.getString("title"));
				param.setViewcnt(rs.getInt("viewcnt"));
				param.setUid(rs.getString("uid"));
				return param;
			}
			return null;
		} catch (Exception e) {
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	
	
	public static int updBoard(BoardVO param) {
		String sql = "UPDATE t_board SET title = ?, ctnt = ? WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static int delBoard(BoardVO param) {
		String sql = "DELETE FROM t_board WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
