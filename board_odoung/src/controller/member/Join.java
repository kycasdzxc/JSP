package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.util.Util;

import domain.Member;
import service.MemberService;

@WebServlet("/member/join")
public class Join extends HttpServlet{
	private MemberService memberService = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
//		String name = req.getParameter("name");
		
		Member member = utils.Util.getParam(req, Member.class);
		
		System.out.println(member);
//		Member member = new Member(id, pw, name);
		memberService.register(member);
//		
		resp.sendRedirect(req.getContextPath() + "/board/list");
	}
}