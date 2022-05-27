package controller.board;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domain.Attach;
import domain.Board;
import domain.Criteria;
import domain.Member;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import service.BoardService;
import service.MemberService;

@WebServlet("/board/register")
public class Register extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();
	private MemberService memberService = MemberService.getInstance();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("member") == null) {
			resp.sendRedirect(req.getContextPath() + "/member/login?link=" + req.getRequestURI() + "?" + URLEncoder.encode(req.getQueryString(), "utf-8"));
			return;
		}
		
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

		req.getRequestDispatcher("/WEB-INF/jsp/board/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria();
		
		Board board = upload(req, cri);
		
		boardService.register(board);
		resp.sendRedirect("list" + cri.getParams2());
	}
	
	private Board upload(HttpServletRequest req, Criteria cri) {
		Board board = new Board();
		String saveDir = "D:\\upload2";
//		String saveDir = "C:\\Users\\human\\Desktop\\Upload";
		int size = 10 * 1024 * 1024;
		
		File currentDir = new File(saveDir);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDir);
		factory.setSizeThreshold(size);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			for(FileItem fi : items) {
				if(fi.isFormField()) {
					if(fi.getFieldName().equals("title")) {
						board.setTitle(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("content")) {
						board.setContent(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("writer")) {
						board.setWriter(fi.getString("utf-8"));
					}
					if(fi.getFieldName().equals("amount")) {
						cri.setAmount(Integer.parseInt(fi.getString("utf-8")));
					}
					if(fi.getFieldName().equals("category")) {
						cri.setCategory(Integer.parseInt(fi.getString("utf-8")));
						board.setCategory(cri.getCategory());
					}
				}
				else {
					if(fi.getSize() == 0) {
						continue;
					}
					
					String origin = fi.getName();
					int idxDot = origin.lastIndexOf(".");
					String ext = "";
					
					if(idxDot != -1) {
						ext = origin.substring(idxDot);
					}
					
					UUID uuid = UUID.randomUUID();
					String name = uuid + ext; // 물리적 uuid
					
					File upPath = new File(currentDir + "\\" + getTodayStr());
					if(!upPath.exists()) {
						upPath.mkdirs();
					}
					fi.write(new File(upPath, name));
					
					Attach attach = new Attach(name, origin, getTodayStr());
					procImageType(attach, upPath, name);
//					Attach attach = new Attach(name, origin, getTodayStr(),
//							fi.getContentType().contains("image"), 1, null);

					board.getAttachs().add(attach);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return board;
	}

	private String getTodayStr() {
		return new SimpleDateFormat("yyyy/MM/dd").format(System.currentTimeMillis());
	}
	
	private void procImageType(Attach attach, File upPath, String name) {
		File file = new File(upPath, name);
		
		try {
			Thumbnails
				.of(file)
				.sourceRegion(Positions.CENTER, 200, 200)
				.size(200, 200)
				.toFile(new File(upPath, "s_" + name));
			attach.setImage(true);
		} catch (IOException ignore) { };
	}
}