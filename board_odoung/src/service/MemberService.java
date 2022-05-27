package service;

import dao.BoardDao;
import dao.MemberDao;
import dao.ReplyDao;
import domain.Member;

public class MemberService {
	private static MemberService memberService = new MemberService();
	public static MemberService getInstance() {
		return memberService;
	}
	private MemberService() {}
	
	private MemberDao memberDao = MemberDao.getInstance();
	private BoardDao boardDao = BoardDao.getInstacne();
	private ReplyDao replyDao = ReplyDao.getInstacne();
	
	public void register(Member member) {
		memberDao.register(member);
	}
	
	public Member login(Member member) {
		return memberDao.login(member.getId(), member.getPw());
	}
	
	public Member get(String id) {
		return memberDao.get(id);
	}
	
	public Member findBy(String email) {
		return memberDao.findBy(email);
	}
	
	public void updateAuthToken(Member member) {
		memberDao.updateAuthToken(member);
	}
	
	public void updateAuth(Member member) {
		memberDao.updateAuth(member);
	}
	
	public void modify(Member member) {
		memberDao.modify(member);
	}
	
	public void remove(Member member) {
//		boardDao.modifyNullByWriter(member.getId());
//		replyDao.modifyNullByWriter(member.getId());
		memberDao.remove(member.getId());
	}
//	public Member member ; // null :: 미배정(비 로그인) / 주소가 있는 상태(로그인)
//	
//	public void register() {
//		System.out.println("회원 가입");
//
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("아이디 > ");
//		String id = scanner.nextLine();
//		System.out.println("비밀번호 > ");
//		String pw = scanner.nextLine();
//		System.out.println("이름 > ");
//		String name = scanner.nextLine();
//		
//		Member member = new Member(id, pw, name);
//		
//		new MemberDao().register(member);
//	}
//	
//	public void modify() {
//		System.out.println("회원 정보 수정");
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("비밀번호 > ");
//		String pw = scanner.nextLine();
//		System.out.println("이름 > ");
//		String name = scanner.nextLine();
//		
//		Member member = new Member(this.member.id, pw, name);
//		
//		new MemberDao().modify(member);
//		this.member = member;
//	}
//	
//	public void remove() {
//		System.out.println("회원 탈퇴");
//		
//		new MemberDao().remove(member.id);
//		logout();
//	}
//	
//	public void login() {
//		System.out.println("로그인");
//
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("아이디 > ");
//		String id = scanner.nextLine();
//		System.out.println("비밀번호 > ");
//		String pw = scanner.nextLine();
//		
//		member = new MemberDao().login(id, pw);
//	}
//	
//	public void logout() {
//		System.out.println("로그아웃");
//		member = null;
//	}
	
}
