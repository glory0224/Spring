package glory.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import glory.spring.web.board.BoardService;
import glory.spring.web.board.BoardVO;
import glory.spring.web.common.Log4jAdvice;
import glory.spring.web.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	// BoardDAO와 BoardDAOSpring 파일을 얼마든지 바꿔가면서 가능
	@Autowired
	private BoardDAOJPA boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		
		boardDAO.insertBoard(vo); // 1000번 글 등록 성공 
		//boardDAO.insertBoard(vo); // Exception 발생 
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
