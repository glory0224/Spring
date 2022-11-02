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
//			System.out.println("---> MyBatis�� insertBoard() ��� ó��");
//			getSqlSession().insert("BoardDAO.insertBoard", vo);
//		}
//		
//		public void updateBoard(BoardVO vo) {
//			System.out.println("---> MyBatis�� updateBoard() ��� ó��");
//			getSqlSession().update("BoardDAO.updateBoard", vo);
//		}
//		
//		public void deleteBoard(BoardVO vo) {
//			System.out.println("---> MyBatis�� deleteBoard() ��� ó��");
//			getSqlSession().delete("BoardDAO.deleteBoard", vo);
//		}
//		
//		public BoardVO getBoard(BoardVO vo) {
//			System.out.println("---> MyBatis�� getBoard() ��� ó��");
//			return getSqlSession().selectOne("BoardDAO.getBoard", vo);
//		}
//		
//		public List<BoardVO> getBoardList(BoardVO vo){
//			System.out.println("---> MyBatis�� getBoardList() ��� ó��");
//			return getSqlSession().selectList("BoardDAO.getBoardList", vo);
//		}
		
		// sqlSessionTemplate�� ����߱� ������ extends�� ���� �ʾƵ� ���� �����Ѵ�. (���յ��� �����.)
		@Autowired
		private SqlSessionTemplate sqlSessionTemplate;
		
		public void insertBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� insertBoard() ��� ó��");
			sqlSessionTemplate.insert("BoardDAO.insertBoard", vo);
		}
		
		public void updateBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� updateBoard() ��� ó��");
			sqlSessionTemplate.update("BoardDAO.updateBoard", vo);
		}
		
		public void deleteBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� deleteBoard() ��� ó��");
			sqlSessionTemplate.delete("BoardDAO.deleteBoard", vo);
		}
		
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("---> MyBatis�� getBoard() ��� ó��");
			return sqlSessionTemplate.selectOne("BoardDAO.getBoard", vo);
		}
		
//		public List<BoardVO> getBoardList(BoardVO vo){
//			System.out.println("---> MyBatis�� getBoardList() ��� ó��");
//			return sqlSessionTemplate.selectList("BoardDAO.getBoardList", vo);
//		}
		
		// �̷� ������� �˻��� �����ϸ� �˻� ���ǿ� ���� ����� SQL ������ �ݺ��ؼ� �ۼ��ؾ��Ѵ�.
		// �ᱹ ���������� ����� DAO Ŭ���� �޼��带 �ǵ�����Ѵ�. 
		// MyBatis�� Dynamic sql�� ���� dao�� �ǵ帱 ���� ������ �����ϴ� ���� ����. 
		
//		public List<BoardVO> getBoardList(BoardVO vo){
//			System.out.println("---> MyBatis�� getBoardList() ��� ó��");
//			if(vo.getSearchCondition().equals("TITLE")) {
//				return sqlSessionTemplate.selectList("BoardDAO.getBoardList_T", vo);
//			}else if(vo.getSearchCondition().equals("CONTENT")) {
//				return sqlSessionTemplate.selectList("BoardDAO.getBoardList_C", vo);
//			}
//			return null;
//			}
		
		// mybatis���� �б� ������ dynamic���� ó�� 
		public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("---> MyBatis�� getBoardList() ��� ó��");
		return sqlSessionTemplate.selectList("BoardDAO.getBoardList", vo);
	}
}