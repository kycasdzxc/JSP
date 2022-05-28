package service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.AttachDao;
import dao.BoardDao;
import dao.ReplyDao;
import domain.Attach;
import domain.Board;
import domain.Criteria;

public class BoardService {
	private static BoardService boardService = new BoardService();
	
	public static BoardService getInstance() {
		return boardService;
	}
	
	private BoardService() {}
	
	private BoardDao boardDao = BoardDao.getInstacne();
	private AttachDao attachDao = AttachDao.getInstacne();
	private ReplyDao replyDao = ReplyDao.getInstacne();
	
	// 글 목록
	public List<Board> list(Criteria criteria) {
		List<Board> list = boardDao.list(criteria);
		
		// 갤러리일 경우
		if(criteria.getCategory() == 3) {
			list.forEach(board->{
				List<Attach> attachList = attachDao.list(board.getBno());
				List<Attach> attachList2 = new ArrayList<>();
				for(Attach attach : attachList) {
					if(attach.isImage()) {
						attachList2.add(attach);
						break;
					}
				}
				board.setAttachs(attachList);
			});
		}
		return list;
	}
	// 글 상세
	public Board get(Long bno) {
		Board board = boardDao.get(bno);
		board.setAttachs(attachDao.list(board.getBno()));
		return board;
	}
	// 글 작성
	public void register(Board board) {
		boardDao.register(board);
//		board.getAttachs().forEach(attach -> {
//			attach.setBno(board.getBno());
//			attachDao.insert(attach);
//		});
		
		for(Attach attach : board.getAttachs()) {			
			attach.setBno(board.getBno());
			attachDao.insert(attach);
		}
	}
	// 글 수정
	public void modify(Board board) {
		boardDao.modify(board);
	}
	// 글 삭제
	public void remove(Long bno) {
		// 1. 첨부파일 조회
		List<Attach> attachs = attachDao.list(bno);
		// 2. 물리적 삭제
//		String saveDir = "C:\\Users\\user\\Desktop\\JAVA\\upload";
		String saveDir = "C:\\upload2";
		
		for(Attach attach : attachs) {
			File file = new File(saveDir, attach.getPath());			
			file = new File(file, attach.getUuid());
			System.out.println(file);
			file.delete();
		}
		// 3. 첨부파일 목록 삭제
		attachDao.remove(bno);
		
		// 3.5 댓글 삭제
		replyDao.removeAll(bno);
		
		// 4. 글 삭제
		boardDao.remove(bno);
	}
	// 글 개수
	public int count(Criteria cri) {
		return boardDao.count(cri);
	}
	public static void main(String[] args) {
		BoardService.getInstance().remove(274L);
	}
}