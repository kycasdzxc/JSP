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

@WebServlet("/member/myPage")
public class MyPage extends HttpServlet{
	private MemberService memberService = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("member") == null) {
			resp.sendRedirect(req.getContextPath() + "/member/login?link=" + req.getRequestURI() + "?" +
						URLEncoder.encode(req.getQueryString() == null ? "" : req.getQueryString(), "utf-8"));
			return;
		}
		Member member = (Member)req.getSession().getAttribute("member");
		member = memberService.get(member.getId());
		req.setAttribute("memberInfo", member);
		
		req.getRequestDispatcher("/WEB-INF/jsp/member/mypage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = utils.Util.getParam(req, Member.class);
//		
		System.out.println(member);
////		Member member = new Member(id, pw, name);
		memberService.modify(member);
		req.setAttribute("msg", "회원 정보가 정상적으로 수정되었습니다.");
		
		req.getRequestDispatcher("/WEB-INF/jsp/common/msg.jsp").forward(req, resp);;
	}
}