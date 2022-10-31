package glory.spring.web.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//BoardVO에 한꺼번에 넣는것이 아닌 xml을 표현할 또다른 vo로 만든다. 

@XmlRootElement(name = "boardList") // xml 문서를 위한 루트 엘리먼트
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	
		@XmlElement(name="board") // name을 정하지 않으면 기본적으로 변수의 이름인 boardList로 사용한다. 
		private List<BoardVO> boardList;
		
		public List<BoardVO> getBoardList(){
			return boardList;
			
		}

		public void setBoardList(List<BoardVO> boardList) {
			this.boardList = boardList;
		}
		
		
}
