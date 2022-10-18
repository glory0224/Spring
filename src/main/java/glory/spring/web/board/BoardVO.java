package glory.spring.web.board;

//sql.Date는 DB에서만 날짜 계산 가능, util.Date는 자바에서만 날짜 계산 가능, 따라서 넘어오면 형변환을 해야 날짜 계산이 가능하다.
// 근본적인 차이는 util.Date는 default 생성자가 존재하는데 sql.Date는 default 생성자가 없다. 
import java.sql.Date; 

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate; 
	private int cnt;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String titile) {
		this.title = titile;
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
