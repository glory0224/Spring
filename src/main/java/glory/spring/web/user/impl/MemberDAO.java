package glory.spring.web.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import glory.spring.web.user.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public MemberVO read(String userid) {
		return sqlSessionTemplate.selectOne("MemberMapper.read", userid);
		
	}
	
}
