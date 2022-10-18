package glory.spring.web.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import glory.spring.web.user.UserService;
import glory.spring.web.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	// setter injection
//	public void setUserDAO(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
