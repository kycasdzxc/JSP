package app;

import java.util.Scanner;

import service.BoardService;
import service.MemberService;
import service.ReplyService;

public class BoardApp {
	public static void main(String[] args) {
		BoardService boardService = BoardService.getInstance();
//		MemberService memberService = new MemberService();
//		ReplyService replyService = new ReplyService();
//		Scanner scanner = new Scanner(System.in);
//
//		
//		while (true) {
//			System.out.println("1.댓글 목록조회 2. 댓글등록 3.댓글삭제 4.게시글 상세조회");
//			int input = Integer.parseInt(scanner.nextLine());
//			switch (input) {
//			case 1:
//				replyService.list();
//				break;
//			case 2:
//				replyService.register();
//				break;
//			case 3:
//				replyService.remove();
//				break;
//				
//			default:
//				break;
//			}
//		}
//		while (true) {
////			System.out.println("1.목록조회 2.등록 3.수정 4.삭제");
//			if(memberService.member == null) {
//				System.out.println("1.회원가입 2.로그인");
//				
//				int input = Integer.parseInt(scanner.nextLine());
//				switch (input) {
//				case 1:
////					boardService.list();
//					memberService.register();
//					break;
//					
//				case 2:
////					boardService.register();
//					memberService.login();
//					break;
//				}
//			}
//			else {
//				System.out.println("1.정보수정 2.탈퇴 3.로그아웃");
//			
//				int input = Integer.parseInt(scanner.nextLine());
//				switch (input) {
//				case 1:
////					boardService.modify();
//					memberService.modify();
//					break;
//				
//				case 2:
////					boardService.remove();
//					memberService.remove();
//					break;
//		
//				case 3:
//					memberService.logout();
//					break;			
//				}
//			}
//		}
	}
}
