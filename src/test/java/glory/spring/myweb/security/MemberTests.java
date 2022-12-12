package glory.spring.myweb.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class MemberTests {
	
	@Setter(onMethod=@__({@Autowired}))
	private PasswordEncoder pwencoder;
			
	@Setter(onMethod=@__({@Autowired}))
	private DataSource ds;
	
	// 테스트 케이스의 에러는 나지만 테이블에 값은 잘 들어감 
	// 사용자 권한을 부여하는 테스트 코드 
		@Test
		public void testInsertAuth() {
			
			String sql = "insert into tbl_member_auth(userid, auth) values (?, ?)";
			
			for(int i = 0; i < 100; i++) {
				Connection con = null;
				PreparedStatement pstmt = null;
				
				try {
					con = ds.getConnection();
					pstmt = con.prepareStatement(sql);
					
					
					if (i < 80) {
						pstmt.setString(1, "user" + i);
						pstmt.setString(2, "ROLE_USER");
					} else if (i < 90) {
						pstmt.setString(1, "manager" + i);
						pstmt.setString(2, "ROLE_MEMBER");
					} else {
						pstmt.setString(1, "admin" + i);
						pstmt.setString(2, "ROLE_ADMIN");
					}
					
					pstmt.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(pstmt != null) {try {pstmt.close();}catch(Exception e) {}}
					if(con != null) {try {con.close();}catch(Exception e) {}}
				}
			}
		}
	
	
	// 100명의 회원 정보르르 기록하는 테스트 코드 작성 
	@Test
	public void testInsertMember() {
		
		String sql = "insert into tbl_member(userid, userpw, username) values (?, ?, ?)";
		
		for(int i = 0; i < 100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(2, pwencoder.encode("pw" + i));
				
				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);
				} else if (i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
				}
				
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) {try {pstmt.close();}catch(Exception e) {}}
				if(con != null) {try {con.close();}catch(Exception e) {}}
			}
		}
	}
	
	
	
}
