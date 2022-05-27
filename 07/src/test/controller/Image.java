package test.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class Image extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		URL url = new URL(req.getParameter("name"));
		InputStream is = url.openStream();
		
		int b = 0;
		
		OutputStream os = resp.getOutputStream();
		
		while((b = is.read()) != -1) {
			os.write(b);
		}
	}
}
