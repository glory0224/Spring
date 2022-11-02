package glory.spring.web.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import glory.spring.web.board.BoardVO;

@Repository
//public class BoardDAOMybatis extends SqlSessionDaoSupport {
public class BoardDAOMybatis {
		
//		@Autowired
//		public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//			super.setSqlSessionFactory(sqlSessionFactory);
//		}
//		
//		public void insertBoard(BoardVO vo) {
//			System.out.println("---> MyBatis로 insertBoard() 기능 처리");
//			getSqlSession().insert("BoardDAO.insertBoard", vo);
//		}
//		
//		public void updateBoard(BoardVO vo) {
//			System.out.println("---> MyBatis로 updateBoard() 기능 처리");
//			getSqlSession().update("BoardDAO.updateBoard", vo);
//		}
//		
//		public void deleteBoard(BoardVO vo) {
//			System.out.println("---> MyBatis로 deleteBoard() 기능 처리");
//			getSqlSession().delete("BoardDAO.deleteBoard", vo);
//		}
//		
//		public BoardVO getBoard(BoardVO vo) {
//			System.out.println("---> MyBatis로 getBoard() 기능 처리");
//			return getSqlSession().selectOne("BoardDAO.getBoard", vo);
//		}
//		
//		public List<BoardVO> getBoardList(BoardVO vo){
//			System.out.println("---> MyBatis로 getBoardList() 기능 처리");
//			return getSqlSession().selectList("BoardDAO.getBoardList", vo);
//		}
		
		// sqlSessionTemplate을 사용했기 때문에 extends를 하지 않아도 정상 동작한다. (결합도를 낮췄다.)
		@Autowired
		private SqlSessionTemplate sqlSessionTemplate;
		
		public void insertBoard(BoardVO vo) {
			System.out.println("---> MyBatis로 insertBoard() 기능 처리");
			sqlSessionTemplate.insert("BoardDAO.insertBoard", vo);
		}
		
		public void updateBoard(BoardVO vo) {
			System.out.println("---> MyBatis로 updateBoard() 기능 처리");
			sqlSessionTemplate.update("BoardDAO.updateBoard", vo);
		}
		
		public void deleteBoard(BoardVO vo) {
			System.out.println("---> MyBatis로 deleteBoard() 기능 처리");
			sqlSessionTemplate.delete("BoardDAO.deleteBoard", vo);
		}
		
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("---> MyBatis로 getBoard() 기능 처리");
			return sqlSessionTemplate.selectOne("BoardDAO.getBoard", vo);
		}
		
//		public List<BoardVO> getBoardList(BoardVO vo){
//			System.out.println("---> MyBatis로 getBoardList() 기능 처리");
//			return sqlSessionTemplate.selectList("BoardDAO.getBoardList", vo);
//		}
		
		// 이런 방식으로 검색을 구현하면 검색 조건에 대한 비슷한 SQL 구문을 반복해서 작성해야한다.
		// 결국 유지보수가 힘들고 DAO 클래스 메서드를 건드려야한다. 
		// MyBatis의 Dynamic sql을 통해 dao는 건드릴 것이 없도록 구현하는 것이 좋다. 
		
//		public List<BoardVO> getBoardList(BoardVO vo){
//			System.out.println("---> MyBatis로 getBoardList() 기능 처리");
//			if(vo.getSearchCondition().equals("TITLE")) {
//				return sqlSessionTemplate.selectList("BoardDAO.getBoardList_T", vo);
//			}else if(vo.getSearchCondition().equals("CONTENT")) {
//				return sqlSessionTemplate.selectList("BoardDAO.getBoardList_C", vo);
//			}
//			return null;
//			}
		
		// mybatis에서 분기 로직은 dynamic으로 처리 
		public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("---> MyBatis로 getBoardList() 기능 처리");
		return sqlSessionTemplate.selectList("BoardDAO.getBoardList", vo);
	}
}
