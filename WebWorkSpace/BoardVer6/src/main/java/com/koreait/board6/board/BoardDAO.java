package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public static int insertBoard(BoardVO param) {
		String sql = "INSERT INTO t_board (title, ctnt, iuser) VALUES (?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static List<BoardVO> selectLise() {
		String sql = "SELECT A.iboard, A.title, B.unm, A.regdt "
				+ "FROM t_board A "
				+ "LEFT JOIN t_user B "
				+ "ON A.iuser = B.iuser";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO temp = new BoardVO(rs.getInt("iboard"), rs.getString("title"), rs.getString("unm"), rs.getString("regdt"));
				list.add(temp);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
}
