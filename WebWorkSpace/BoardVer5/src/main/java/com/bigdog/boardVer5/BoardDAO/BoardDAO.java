package com.bigdog.boardVer5.BoardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	//글 목록 불러오기
	public static List<BoardVO> selBoard() {
		String sql = "SELECT A.iboard, A.title, A.regdt, "
				+ "A.viewcnt, A.likecnt, A.dislike, COUNT(B.icmt) AS cmtcnt "
				+ "FROM t_board A LEFT JOIN t_cmt B "
				+ "ON A.iboard = B.iboard GROUP BY A.iboard "
				+ "ORDER BY A.iboard DESC";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				int viewcnt = rs.getInt("viewcnt");
				int likecnt = rs.getInt("likecnt");
				int dislike = rs.getInt("dislike");
				int cmtcnt = rs.getInt("cmtcnt");
				BoardVO vo = new BoardVO(iboard, title, regdt, viewcnt, likecnt, dislike, cmtcnt);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	//목록에서 검색
	public static List<BoardVO> searchBoard(BoardVO param) {
		String sql = "SELECT A.iboard, A.title, A.regdt, "
				+ "A.viewcnt, A.likecnt, A.dislike, COUNT(B.icmt) AS cmtcnt "
				+ "FROM t_board A LEFT JOIN t_cmt B "
				+ "ON A.iboard = B.iboard "
				+ "WHERE title LIKE ? "
				+ "GROUP BY A.iboard "
				+ "ORDER BY A.iboard DESC";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + param.getTitle() + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				int viewcnt = rs.getInt("viewcnt");
				int likecnt = rs.getInt("likecnt");
				int dislike = rs.getInt("dislike");
				int cmtcnt = rs.getInt("cmtcnt");
				BoardVO vo = new BoardVO(iboard, title, regdt, viewcnt, likecnt, dislike, cmtcnt);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	//게시글 불러오기
	public static BoardVO selBoard(BoardVO param) {
		String sql1 = "SELECT * "
				+ "FROM t_board WHERE iboard = ?";
		BoardVO vo;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql1);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			if(rs.next()) {
				int iboard = param.getIboard();
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				int viewcnt = rs.getInt("viewcnt");
				int likecnt = rs.getInt("likecnt");
				int dislike = rs.getInt("dislike");
				vo = new BoardVO(iboard, title, ctnt, regdt, viewcnt, likecnt, dislike);
				return vo;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	//글 쓰기
	public static int writeBoard(BoardVO vo) {
		String sql1 = "INSERT INTO t_board (title, ctnt) VALUES (?, ?) ";
		String sql2 = "SELECT MAX(iboard) AS maxiboard FROM t_board";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql1);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxiboard");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	//글 수정
	public static int modifyBoard(BoardVO vo) {
		String sql = "UPDATE t_board SET title = ?, ctnt = ?, regdt = NOW() WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	//글 삭제
	public static int deleteBoard(BoardVO vo) {
		String sql = "DELETE FROM t_board WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	//======================== 댓글 기능 =================
	
	// 댓글 목록
	public static List<ComentVO> readCmts(BoardVO vo) {
		String sql = "SELECT * FROM t_cmt WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			rs = ps.executeQuery();
			List<ComentVO> cmts = new ArrayList<ComentVO>();
			while(rs.next()) {
				
				int iboard = rs.getInt("iboard");
				int icmt = rs.getInt("icmt");
				String cmt = rs.getString("cmt");
				String cmtID = rs.getString("cmtID");
				String cmt_regdt = rs.getString("cmt_regdt");
				int likecnt = rs.getInt("likecnt");
				int dislike = rs.getInt("dislike");
				ComentVO cvo = new ComentVO(iboard, icmt, cmt, cmtID, cmt_regdt, likecnt, dislike);
				cmts.add(cvo);
			}
			return cmts;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	// 댓글 쓰기
	public static int writeComent(ComentVO cvo) {
		String sql = "INSERT INTO t_cmt (iboard, cmt, cmtID) VALUES (?, ?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cvo.getIboard());
			ps.setString(2, cvo.getCmt());
			ps.setString(3, cvo.getCmtID());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	// 댓글 삭제
	public static int deleteComent(ComentVO cvo) {
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
	
	// ============================== 조회수 좋아요 싫어요 =========================
	public static int viewCount(BoardVO vo) {
		String sql = "UPDATE t_board SET viewcnt = viewcnt + 1 WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int likeBoard(BoardVO vo, boolean like) {
		String sql = "UPDATE t_board SET likecnt = likecnt + ?, dislike = dislike + ? WHERE iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			if(like) {
				ps.setInt(1, 1);
				ps.setInt(2, 0);
			} else {
				ps.setInt(1, 0);
				ps.setInt(2, 1);
			}
			ps.setInt(3, vo.getIboard());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int likeComent(ComentVO cvo, boolean islike) {
		String sql = "UPDATE t_cmt SET likecnt = likecnt + ?, dislike = dislike + ? WHERE icmt = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			if(islike) {
				ps.setInt(1, 1);
				ps.setInt(2, 0);
			} else {
				ps.setInt(1, 0);
				ps.setInt(2, 1);
			}
			ps.setInt(3, cvo.getIcmt());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
}
