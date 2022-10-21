package glory.spring.web.board;

//sql.Date�� DB������ ��¥ ��� ����, util.Date�� �ڹٿ����� ��¥ ��� ����, ���� �Ѿ���� ����ȯ�� �ؾ� ��¥ ����� �����ϴ�.
// �ٺ����� ���̴� util.Date�� default �����ڰ� �����ϴµ� sql.Date�� default �����ڰ� ����. 
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