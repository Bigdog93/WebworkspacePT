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
	
	// 글 삽입하기
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
	
	// 글목록 가져오기
	public static List<BoardVO> selectLise() {
		String sql = "SELECT A.iboard, A.title, B.unm, A.regdt "
				+ "FROM t_board A "
				+ "LEFT JOIN t_user B "
				+ "ON A.iuser = B.iuser "
				+ "ORDER BY A.iboard DESC";
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
	
	// 디테일 가져오기
	public static void selectBoard(BoardVO vo) {
		String sql = "SELECT * FROM t_board A LEFT JOIN t_user B ON A.iuser = B.iuser WHERE iboard = ?  ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setDislike(rs.getInt("dislike"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setLikecnt(rs.getInt("likecnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
				vo.setViewcnt(rs.getInt("viewcnt"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	//게시글 삭제
	public static int deleteBoard(BoardVO vo) {
		String sql = "DELETE FROM t_board WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	//게시글 수정
	public static int modifyBoard(BoardVO vo) {
		String sql = "UPDATE t_board SET title = ?, ctnt = ? WHERE iboard = ? AND iuser = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, vo.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
