package controller.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.util.Util;

import domain.Member;
import service.MemberService;

@WebServlet("/member/secession")
public class Secession extends HttpServlet{
	private MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = utils.Util.getParam(req, Member.class);
		System.out.println(member);
		
		memberService.remove(member);
		resp.sendRedirect("logout");
//////		Member member = new Member(id, pw, name);
//		memberService.modify(member);
//		req.setAttribute("msg", "회원 정보가 정상적으로 수정되었습니다.");
//		
//		req.getRequestDispatcher("/WEB-INF/jsp/common/msg.jsp").forward(req, resp);;
	}
}