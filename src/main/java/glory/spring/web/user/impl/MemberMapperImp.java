package glory.spring.web.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import glory.spring.web.user.MemberMapper;
import glory.spring.web.user.MemberVO;

@Service
public class MemberMapperImp implements MemberMapper {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO read(String userid) {
		return memberDAO.read(userid);
		
		
	}

}
