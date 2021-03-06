package com.board.boardVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;
	
	public void getCon() {
	      // 커넥션풀을 이용해 DB접근하기!
	      try {
	         //외부에서 데이터 가져오기
	         Context initctx = new InitialContext();
	         //톰캣 서버에 정보를 담아놓은 곳으로 이동하기
	         Context envctx = (Context) initctx.lookup("java:comp/env");
	         //데이터 소스 객체를 선언
	         DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
	         //데이터 소스를 기준으로 커넥션을 연결!
	         con = ds.getConnection();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("연결 실패...");
	      }
	   }
	
	public void insertBoard(BoardVO vo) {
		try {
			getCon();
			String sql = "INSERT INTO board (title, ctnt) VALUES (?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getCtnt());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {

		}
	}
	
	public List<BoardVO> selectBoard() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			getCon();
			String sql = "SELECT * FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoard_idx(rs.getInt("serialNum"));
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setLike(rs.getInt("likecnt"));
				vo.setDislike(rs.getInt("dislike"));
				vo.setView(rs.getInt("viewcnt"));
				list.add(vo);
			}
			con.close();
		} catch (Exception e) {
		}
		return list;
		
	}
	
	public BoardVO selectDetail(int idx) {
		BoardVO vo = new BoardVO();
		try {
			getCon();
			String sql = "SELECT * FROM board WHERE serialNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setBoard_idx(rs.getInt("serialNum"));
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setLike(rs.getInt("likecnt"));
				vo.setDislike(rs.getInt("dislike"));
				vo.setView(rs.getInt("viewcnt"));
			}
			con.close();
		} catch (Exception e) {
			
		}
		return vo;
	}
	
	public void plus(int idx, String cntName) {
		try {
			getCon();
			// pstmt는 필드"값"만 지정 가능. 필드명은 ?로 지정 불가능!!
			String sql = "UPDATE board SET "+cntName+" = "+cntName+" + 1 WHERE serialNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBoard(int idx, BoardVO vo) {
		try {
			getCon();
			String sql = "UPDATE board SET title = ?, ctnt = ? WHERE serialNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getCtnt());
			pstmt.setInt(3, idx);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteBoard(int idx) {
		try {
			getCon();
			String sql = "DELETE from board WHERE serialNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
