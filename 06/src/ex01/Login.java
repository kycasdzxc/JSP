package ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if(req.getMethod().equals("GET")) {
//			req.getRequestDispatcher("/WEB-INF/jsp/member/login.jsp").forward(req, resp);
//		}
//		else {
//			resp.setStatus(405);
//		}
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("실제 해야할 일");
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);
//	}
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면 담당
		req.getRequestDispatcher("/WEB-INF/jsp/member/login.jsp").forward(req, resp);
		// 정보 은닉하기
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로직 담당
		// post 방식으로 parameter 전송시 req의 header에 포함시켜 전송(1byte 분할 방식)
		
		// req의 인코딩 타입이 무엇으로 오는가?
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		System.out.println(id);
		System.out.println(pw);
	}
}
