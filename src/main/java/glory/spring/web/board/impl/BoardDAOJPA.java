package glory.spring.web.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import glory.spring.web.board.BoardVO;

// ������ ��ĸ��� �ϳ��� Repository�� ����ؾ��Ѵ�. ���� JPA ����� DAO�� ����� ��� �ٸ� DAO ������ @Repository�� �ּ�ó���ؾ��Ѵ�. 
@Repository
public class BoardDAOJPA {
	
		@PersistenceContext
		private EntityManager manager;
		
		public void insertBoard(BoardVO vo) {
			System.out.println("JPA�� insertBoard() ��� ó��");
			manager.persist(vo);
		}
		
		public void updateBoard(BoardVO vo) {
			System.out.println("JPA�� updateBoard() ��� ó��");
			manager.merge(vo);
		}
		
		public void deleteBoard(BoardVO vo) {
			System.out.println("JPA�� deleteBoard() ��� ó��");
			manager.remove(manager.find(BoardVO.class, vo.getSeq()));
		}
		
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("JPA�� getBoard() ��� ó��");
			return manager.find(BoardVO.class, vo.getSeq());		
			
		}
		
		public List<BoardVO> getBoardList(BoardVO vo){
			System.out.println("JPA�� getBoardList() ��� ó��");
			return manager.createQuery("select vo from BoardVO vo order by vo.seq desc", BoardVO.class).getResultList();
		}
}
