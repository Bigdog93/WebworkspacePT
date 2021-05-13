package com.koreait.board6.coment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;
import com.koreait.board6.board.BoardVO;

public class ComentDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static int insertCmt(ComentVO cvo) {
		String sql = "INSERT INTO t_cmt (iuser, iboard, ctnt) VALUES (?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cvo.getIuser());
			ps.setInt(2, cvo.getIboard());
			ps.setString(3, cvo.getCtnt());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static List<ComentVO> selectCmtList(BoardVO vo) {
		String sql = "SELECT A.*, B.uid FROM t_cmt A LEFT JOIN t_user B ON A.iuser = B.iuser WHERE A.iboard = ?";
		List<ComentVO> cmtList = new ArrayList<ComentVO>();
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			rs = ps.executeQuery();
			while(rs.next()) {
				ComentVO cvo = new ComentVO(rs.getInt("icmt"), rs.getInt("iboard"),rs.getInt("iuser"), rs.getString("uid"), rs.getString("ctnt"), 
						rs.getString("regdt"), rs.getInt("likecnt"), rs.getInt("dislike"));
				cmtList.add(cvo);
			}
			return cmtList;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public static int deleteCmt(ComentVO cvo) {
		String sql = "DELETE FROM t_cmt WHERE icmt = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cvo.getIcmt());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
