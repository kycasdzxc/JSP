package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it")
public class It extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rss = req.getParameter("rss");
		rss = rss == null ? "https://www.hani.co.kr/rss/international" : rss;

		URL url = new URL(rss);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		resp.setContentType("text/xml; charset=utf-8");
		
		String s = null;
		while((s = br.readLine()) != null) {
			resp.getWriter().println(s);
		}
	}
	
}
