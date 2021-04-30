package com.koreait.board4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Data Access Object(DB 담당)
public class BoardDAO {

	//글 등록
	public static int insertBoard(BoardVO vo) {
		Connection con = null; // 다리연결, PreparedStatement 객체 생성해주는 아이
		PreparedStatement ps = null; // 쿼리문을 완성, 실행까지 해주는 아이
		// sql문을 ?로 해서 PreparedStatement 객체에 넣어주고, 뒤에 set메소드로 ?부분에 넣어주면 개꿀(sql문법에 따라 ''도 알아서 넣어준다.)
		// ps가 없으면, ('" + vo.getTitle() + "', '" + vo.getCtnt() + "')" 이렇게 만들어줘야한다...
		
		
		String sql = " INSERT INTO t_board (title, ctnt) VALUES (?, ?) ";
		
		try {
			con = DBUtils.getCon(); // 다리 연결...
			ps = con.prepareStatement(sql); // 연결된 다리로 부터 준비된 상태 객체 생성
			ps.setString(1, vo.getTitle()); // (몇번째 물음표에 넣을건지, 어떤 값을 넣을건지)
			ps.setString(2, vo.getCtnt()); // 2번째 물음표 자리에 vo.getCtnt()값을 넣을꼬야
			return ps.executeUpdate(); // INSERT, DELETE, UPDATE 때는 얘로 하면 된다.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps); // 리턴 하고서도 실행되기 때문에, 위에 리턴하면서 쿼리문 실행하고 나서도 connection은 무조건 닫힌다.
		}
		
		return 0;
	}
	
	public static List<BoardVO> selectBoard() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT iboard, title, regdt FROM t_board "; // ; 넣으면 아마 에러.. 외부에서의 ;를 이용한 데이터베이스 접근을 막기 위함
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); // 셀렉트만 얘 쓸꺼야
			while(rs.next()) { // rs.next() : 첫번째 실행되면 첫번째 줄을 가리킨다.(일종의 포인터) 가리켰는데 레코드가 있으면 true, 없으면 false 반환
				BoardVO vo = new BoardVO(rs.getInt("iboard"), rs.getString("title"), null, rs.getString("regdt"));
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
	
	// 글 불러오기
	public static BoardVO selectBoard(int idx) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT title, ctnt, regdt FROM t_board WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				BoardVO vo = new BoardVO(idx, title, ctnt, regdt);
				return vo;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	//글 삭제
	public static int deleteBoard(int idx) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM i_board WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	// 글 수정
	public static int modifyBoard(int idx, BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE i_board SET title = ?, ctnt = ? WHERE iboard = ? ";
		 try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, idx);
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtils.close(con, ps);
		}
		 return 0;
	}
}
