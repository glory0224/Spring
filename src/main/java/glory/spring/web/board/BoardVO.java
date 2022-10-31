package glory.spring.web.board;

import java.util.Date;

//sql.Date는 DB에서만 날짜 계산 가능, util.Date는 자바에서만 날짜 계산 가능, 따라서 넘어오면 형변환을 해야 날짜 계산이 가능하다.
// 근본적인 차이는 util.Date는 default 생성자가 존재하는데 sql.Date는 default 생성자가 없다. 
//import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore; 
// java 11버전에서는 xmlAccessorType이 삭제되어서 나오지 않는다. pom.xml에서 dependency를 주입해서 사용한다. 
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardVO {
	
	@XmlAttribute
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate; // 특정 자바 객체를 XML로 변환하기 위해선 반드시 해당 클래스의 기본 생성자가 있어야한다. -> util.Date로 변경한다. 이유: sql.Date는 기본 생성자가 없는 객체라서  
	private int cnt;
	// 검색 조건
	@XmlTransient // xml 변환에서 제외 
	private String searchCondition;
	@XmlTransient // xml 변환에서 제외
	private String searchKeyword;
	// 파일 업로드 // xml 변환에서 제외
	@XmlTransient
	private MultipartFile uploadFile;
	
	// null값으로 넘어오는 get메서드의 json은 안나오도록 하는 어노테이션
	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}
	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + "]";
	}
	
	
}
