package domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Board {
	// int(기본형), Integer(참조형) : null 처리 가능여부
	private Long bno; // PK : 기본키
	private String title;
	private String content;
	private int hitCount;
	private String regDate;
	private int category;
	
	private String writer; // FK : 외래키
	// 아이디, 조회수, 작성시각

	private List<Attach> attachs = new ArrayList<>();
	private int replyCnt;
	
	// 등록작업
	public Board(String title, String content, String writer, int category) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.category = category;
	}
	
	// 수정작업
	public Board(Long bno, String title, String content, int category) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.category = category;
	}
	
	// 조회작업
	public Board(Long bno, String title, String content, int hitCount, String regDate, int category, String writer) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.hitCount = hitCount;
		this.regDate = regDate;
		this.category = category;
		this.writer = writer;
	}
	
	public static void main(String[] args) {
//		Board board = new Board(1L, "제목", "내용", "작성자");
//		
//		Board board2 = new Board();
//		board2.setBno(2L);
//		board2.setTitle("제목");
//		board2.setContent("내용");
//		board2.setWriter("작성자");
//		
//		Board board3 = Board.builder().bno(3L).title("제목").content("내용").writer("작성자").build();
//		
//		System.out.println(board);
//		System.out.println(board2);
//		System.out.println(board3);
	}
}
