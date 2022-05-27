package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		String context = req.getContextPath();
		String url = req.getRequestURL().toString();
		String mapping = req.getServletPath();
		String uri = req.getRequestURI();
		String ip = req.getRemoteAddr();
		String host = req.getRemoteHost();
		
		String str = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>Test Servlet</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"    <h3>TestServlet2 입니다</h3>\r\n" + 
				"    <h3>컨텍스트 이름 : " + context + "</h3>\r\n" + 
				"    <h3>전체경로 " + url + "</h3>\r\n" + 
				"    <h3>매핑이름 " + mapping + "</h3>\r\n" + 
				"    <h3>URI " + uri + "</h3>\r\n" + 
				"    <h3>ip " + ip + "</h3>\r\n" + 
				"    <h3>host " + host + "</h3>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		out.print(str);
	}
}