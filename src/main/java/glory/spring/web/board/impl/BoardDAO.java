package glory.spring.web.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import glory.spring.web.board.BoardVO;
import glory.spring.web.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content)"
						+ "values((select nvl(max(seq), 0)+1 from myboard), ?,?,?)";
	private final String BOARD_UPDATE = "update myboard set title=?,"
						+ "content=? where seq=?";
	private final String BOARD_DELETE = "delete from myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
	// 검색에 따른 BOARD_LIST 쿼리 분리하기
	//private final String BOARD_LIST = "select * from myboard order by seq desc";
	//title (검색 시 bind)
	private final String BOARD_LIST_T = 
			"select * from myboard where title like '%'||?||'%' order by seq desc ";
	//content (검색 시 bind)
	private final String BOARD_LIST_C = 
			"select * from myboard where content like '%'||?||'%' order by seq desc ";
	
	// 글쓰기
	public void insertBoard(BoardVO vo) {
		System.out.println("JDBC로 insertBoard() 기능 처리");
		try {
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(BOARD_INSERT);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2,vo.getWriter());
		pstmt.setString(3, vo.getContent());
		pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	
	// 글 수정 
	public void updateBoard(BoardVO vo) {
		System.out.println("JDBC로 updateBoard() 기능 처리 ");
		try {
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(BOARD_UPDATE);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setInt(3, vo.getSeq());
		pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
			
	}
	
	//게시글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("JDBC로 deleteBoard() 기능 처리");
		try {
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(BOARD_DELETE);
		pstmt.setInt(1, vo.getSeq());
		pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		}
	
	// 게시글 내용 반환
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		
		try {
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(BOARD_GET);
		pstmt.setInt(1, vo.getSeq());
		rs = pstmt.executeQuery();
		if(rs.next()) {
			board = new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegDate(rs.getDate("regdate"));
			board.setCnt(rs.getInt("cnt"));
		}
		
		}catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(rs, pstmt, conn);
	}
		return board;
	}
	
	// 게시글 리스트 반환 	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
		conn = JDBCUtil.getConnection();
		// sql like 바인딩 방법 
		if(vo.getSearchCondition().equals("TITLE")) {
			pstmt = conn.prepareStatement(BOARD_LIST_T);
		} else if (vo.getSearchCondition().equals("CONTENT")) {
			pstmt = conn.prepareStatement(BOARD_LIST_C);
		}
		pstmt.setString(1, vo.getSearchKeyword());
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegDate(rs.getDate("regdate"));
			board.setCnt(rs.getInt("cnt"));
			boardList.add(board);
		}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(rs, pstmt, conn);
	}
		return boardList;
	}
}
