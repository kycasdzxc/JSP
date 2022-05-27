package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import service.MemberService;

@WebServlet("/member/login")
public class Login extends HttpServlet{
	private MemberService memberService = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String link = req.getParameter("link");
		
		Member member = memberService.login(new Member(id, pw, null));
		if(member == null) {
//			resp.sendRedirect(req.getRequestURI());
			req.setAttribute("msg", "로그인 실패");
			req.setAttribute("href", req.getRequestURI() + (link == null ? "" : "?link=" + link));
			req.getRequestDispatcher("/WEB-INF/jsp/common/msg.jsp").forward(req, resp);
		}
		else {
			req.getSession().setAttribute("member", member);
			
			link = link == null ? req.getContextPath()+"/board/list" : link;
			
			req.setAttribute("msg", "로그인 성공");
			req.setAttribute("href", link);
			req.getRequestDispatcher("/WEB-INF/jsp/common/msg.jsp").forward(req, resp);
		}
	}
}