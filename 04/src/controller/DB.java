package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;

@WebServlet("/db")
public class DB extends HttpServlet{

	private StudentService studentService = new StudentService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("테스트!");
		req.setAttribute("students", studentService.list());
		req.getRequestDispatcher("/db2.jsp").forward(req, resp);
	}
}
