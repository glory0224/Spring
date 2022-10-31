package glory.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import glory.spring.web.board.BoardVO;


@Repository
public class BoardDAOSpring {
	// xml 설정 방식 
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content)"
			+ "values((select nvl(max(seq), 0) + 1 from myboard), ?,?,?)";
	
	// seq를 자동생성하지 않고 직접 넣는 방식을 사용해서 일부러 에러를 내고 transaction 동작 확인
//	private final String BOARD_INSERT = 
//						"insert into myboard(seq, title, writer, content) values(?, ?, ?, ?)";
	private final String BOARD_UPDATE = "update myboard set title=?, content=?, where seq=?";
	private final String BOARD_DELETE = "delete myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
//	private final String BOARD_LIST = "select * from myboard order by seq desc";
	private final String BOARD_LIST_T = 
			"select * from myboard where title like '%'||?||'%' order by seq desc ";
	//content (검색 시 bind)
	private final String BOARD_LIST_C = 
			"select * from myboard where content like '%'||?||'%' order by seq desc ";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(),vo.getWriter(), vo.getContent());
		// transaction 확인을 위해 seq도 직접 등록
		//jdbcTemplate.update(BOARD_INSERT, vo.getSeq(),vo.getTitle(),vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("Spring JDBC로 getBoard() 기능 처리");
		Object[] args = { vo.getSeq()};
		// RowMapper 객체가 매개변수로 필요함 
		return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("Spring JDBC로 getBoardList() 기능 처리");
		Object[] args = {vo.getSearchKeyword() };
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, new BoardRowMapper(), args);
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, new BoardRowMapper(), args);
		}
		return null;
		
		// RowMapper 객체가 매개변수로 필요함 
		//return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}
