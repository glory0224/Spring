package glory.spring.web.common.handler;

import org.springframework.security.crypto.password.PasswordEncoder;

// 스프링 4버전까지는 NoOpPasswordEncoder 이용해서 처리 가능했지만 , 5버전부터는 사라졌기 때문에 직접 passwordEncoder를 구현해서 사용한다. 
public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("before encode : " + rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("matches : " + rawPassword + ":" + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}

}
