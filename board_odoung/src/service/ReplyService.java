package service;

import java.util.List;

import dao.ReplyDao;
import domain.Reply;

public class ReplyService {
	private static ReplyService replyService = new ReplyService();
	
	public static ReplyService getInstance() {
		return replyService;
	}
	
	private ReplyService() {}
	
	private ReplyDao replyDao = ReplyDao.getInstacne();
	
	// 댓글 목록
	public List<Reply> list(Long bno) {
		return replyDao.list(bno);
	}
	// 댓글 상세
	public Reply get(Long rno) {
		return replyDao.get(rno);
	}
	// 댓글 작성
	public void register(Reply reply) {
		replyDao.register(reply);
	}
	// 댓글 수정(글 내용 수정, 시간을 현재시간으로)
	public void modify(Reply reply) {
		replyDao.modify(reply);
	}
	// 댓글 삭제
	public void remove(Long rno) {		
		replyDao.remove(rno);
	}
}