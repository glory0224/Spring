package glory.spring.web.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import glory.spring.web.board.BoardVO;

// jdbcTemplate�� queryForObject, query �޼ҵ��� �Ű������� RowMapper�� �ʿ��ϱ� ������ �������̽� ��� 
public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setContent("cnt");
		return board;
	}

}
