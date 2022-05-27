package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownloader extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String origin = req.getParameter("origin");
		String uuid = req.getParameter("uuid");
		String path = req.getParameter("path");
		
//		String saveDir = "C:\\Users\\user\\Desktop\\JAVA\\upload";
		String saveDir = "C:\\Users\\human\\Desktop\\Upload";
		
		File file = new File(new File(saveDir, path), uuid);
		String mime = getServletContext().getMimeType(file.toString());
		if(mime == null) {
			mime = "application/octet-stream";
		}
		
		String fileName = new String(origin.getBytes("utf-8"), "iso-8859-1");
		
		resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream os = resp.getOutputStream();
		
		int b;
		byte[] bytes = new byte[8192];
		while((b = fis.read(bytes, 0, bytes.length)) != -1) {
			os.write(bytes, 0, b);
		}
		fis.close();
		os.close();
	}
}
