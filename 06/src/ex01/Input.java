package ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class Input extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/input.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		String[] subjects = req.getParameterValues("subject");
		
		System.out.println(id);
		System.out.println(pw);
		
		for(String subject : subjects) {
			System.out.println("선택한 과목 : " + subject);

		}
		req.getRequestDispatcher("/WEB-INF/jsp/member/input_test.jsp").forward(req, resp);
	}
}
