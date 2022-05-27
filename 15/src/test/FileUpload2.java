package test;

import java.io.File;
import java.io.IOException;
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

@WebServlet("/file2")
public class FileUpload2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir = "C:\\Users\\user\\Desktop\\JAVA\\upload";
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
					System.out.println(fi.getFieldName() + " = " + fi.getString("utf-8"));
				}
				else {
					System.out.println(fi.getFieldName());

					String origin = fi.getName();
					System.out.println(origin);
					String ext = origin.substring(origin.lastIndexOf("."));
					
					UUID uuid = UUID.randomUUID();
					String name = uuid + ext;
					
					System.out.println(fi.getSize());
					File upPath = new File(currentDir + "\\" + getTodayStr());
					if(!upPath.exists()) {
						upPath.mkdirs();
					}
					fi.write(new File(upPath, name));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private String getTodayStr() {
		return new SimpleDateFormat("yyyy/MM/dd").format(System.currentTimeMillis());
	}
}