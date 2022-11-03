package glory.spring.web.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import glory.spring.web.board.BoardVO;

// 각각의 방식마다 하나의 Repository를 등록해야한다. 만약 JPA 방식의 DAO를 사용할 경우 다른 DAO 파일의 @Repository는 주석처리해야한다. 
@Repository
public class BoardDAOJPA {
	
		@PersistenceContext
		private EntityManager manager;
		
		public void insertBoard(BoardVO vo) {
			System.out.println("JPA로 insertBoard() 기능 처리");
			manager.persist(vo);
		}
		
		public void updateBoard(BoardVO vo) {
			System.out.println("JPA로 updateBoard() 기능 처리");
			manager.merge(vo);
		}
		
		public void deleteBoard(BoardVO vo) {
			System.out.println("JPA로 deleteBoard() 기능 처리");
			manager.remove(manager.find(BoardVO.class, vo.getSeq()));
		}
		
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("JPA로 getBoard() 기능 처리");
			return manager.find(BoardVO.class, vo.getSeq());		
			
		}
		
		public List<BoardVO> getBoardList(BoardVO vo){
			System.out.println("JPA로 getBoardList() 기능 처리");
			return manager.createQuery("select vo from BoardVO vo order by vo.seq desc", BoardVO.class).getResultList();
		}
}
