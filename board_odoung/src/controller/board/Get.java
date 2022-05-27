package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Criteria;
import service.BoardService;

@WebServlet("/board/get")
public class Get extends HttpServlet {
	private BoardService boardService = BoardService.getInstance();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bno = Long.parseLong(req.getParameter("bno"));
		
		Criteria criteria = new Criteria();
		if(req.getParameter("pageNum") != null) {
			criteria.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		}
		if(req.getParameter("amount") != null) {
			criteria.setAmount(Integer.parseInt(req.getParameter("amount")));
		}
		if(req.getParameter("category") != null) {
			criteria.setCategory(Integer.parseInt(req.getParameter("category")));
		}
		req.setAttribute("cri", criteria);
		
		req.setAttribute("board", boardService.get(bno));
		req.getRequestDispatcher("/WEB-INF/jsp/board/get.jsp").forward(req, resp);
	}
}