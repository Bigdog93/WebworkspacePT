package com.koreait.board9.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board9.DBUtils;

public class BoardDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList<BoardDomain>();
		
		String sql = "SELECT A.iboard, A.title, A.iuser, A.regdt, B.unm as writerNm "
				+ "FROM t_board A "
				+ "INNER JOIN t_user B "
				+ "ON A.iuser = B.iuser ";
		
		switch(param.getSearchType()) {
		case 1:
			sql += String.format("WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' ", param.getSearchText(), param.getSearchText());
			break;
		case 2:
			sql += String.format("WHERE A.title LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 3:
			sql += String.format("WHERE A.ctnt LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 4:
			sql += String.format("WHERE B.unm LIKE '%%%s%%' ", param.getSearchText());
			break;
		}
		
		sql += "ORDER BY iboard DESC "
				+ "LIMIT ?, ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDomain vo = new BoardDomain();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setWriterNm(rs.getString("writerNm"));
				list.add(vo);
			}
		} catch (Exception e) {
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static int maxPage(BoardDTO param) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CEIL(COUNT(iboard)/?) AS maxpage FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser ");
		if(param.getSearchType() > 0) {
			sql.append("WHERE ");
		}
		switch(param.getSearchType()) {
		case 1:
			sql.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 2:
			sql.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 3:
			sql.append("A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 4:
			sql.append("B.unm LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		}
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, param.getRecordCnt());
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxpage");
			}
			return 0;
		} catch (Exception e){
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static BoardDomain selBoard(BoardDTO param) {
		String sql = "SELECT A.title, A.ctnt, A.regdt, A.iuser"
				+ ", B.unm AS writerNm "
				+ "FROM t_board A "
				+ "LEFT JOIN t_user B "
				+ "ON A.iuser = B.iuser "
				+ "WHERE A.iboard = ?";
		BoardDomain vo = null;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardDomain();
				vo.setCtnt(rs.getString("ctnt"));
				vo.setIboard(param.getIboard());
				vo.setRegdt(rs.getString("regdt"));
				vo.setTitle(rs.getString("title"));
				vo.setWriterNm(rs.getString("writerNm"));
				vo.setIuser(rs.getInt("iuser"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return vo;
	}
	
	public static int delBoard(BoardDTO param) {
		String sql = "DELETE FROM t_board WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
