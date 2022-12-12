package glory.spring.web.common.handler;

import org.springframework.security.crypto.password.PasswordEncoder;

// ������ 4���������� NoOpPasswordEncoder �̿��ؼ� ó�� ���������� , 5�������ʹ� ������� ������ ���� passwordEncoder�� �����ؼ� ����Ѵ�. 
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
