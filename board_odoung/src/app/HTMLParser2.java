package app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser2 {
	public static void main(String[] args) throws Exception{
		Connection conn = Jsoup.connect("https://www.goodchoice.kr/product/search/3");
		Document doc = conn.get();
		Elements elements = doc.select(".list_2");
		for(int i = 0; i < 7 ; i++) {
			Element el = elements.get(i);
//			System.out.println(el);
//			String no = el.getElementsByTag("a").attr("data-ano");
			String no = el.select("a").attr("data-ano");
			System.out.println("번호 : " + no);
			
			Element el2 = el.select(".name").get(0);
				
			String title = el2.selectFirst("strong").outerHtml();
			System.out.println("펜션이름 : " + title);
			
			String around = el2.select("p").get(1).text();
			System.out.println("주변지역 : " + around);
			
			String price1= el.select(".map_html").select("em").text();
			System.out.println("이전 가격 : " +price1+"원");
			String price= el.select(".map_html").select("p").text();
			System.out.println("가격 : " +price);
			
			String link = el.getElementsByTag("a").attr("href");
			System.out.println("상세링크 : " + link);
			
			String pic = el.selectFirst(".pic img").attr("src");
			System.out.println("이미지경로 : " + pic);
//				String around = el2.getEle;
//				System.out.println(around);
			
				
//			String info = el.selectFirst(".list_info").text();
//			String price = el.selectFirst(".price").text();
//			String link = el.selectFirst(".list_info a").attr("href");
//			Element img = el.selectFirst(".list_img img");

//			Map<String, String> map = new HashMap<>();
//			map.put("no", no);
//			map.put("title", title);
//			map.put("info", info);
//			map.put("price", price);
//			map.put("link", link);
////			System.out.println(no);
////			System.out.println(title);
////			System.out.println(info);
////			System.out.println(price);
////			System.out.println(link);
//			
////			System.out.println(img.attr("data-original"));
//			
////			saveDB(map);
//			saveFile(no, img.attr("data-original"));
			System.out.println(no + "번 작업 완료");
			System.out.println();
		}
	}
	
	static void saveFile(String no, String imgSrc) throws Exception {
		URL url = new URL(imgSrc);

		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		File file = new File("C:\\mu", no);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(file, "thumb.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		
		int b = 0;
		while((b = bis.read()) != -1) {
			bos.write(b);
		}
		
		bos.close();
	}
	
//	static void saveDB(Map<String, String> map) throws Exception {
//		PreparedStatement pstmt = DBConn.getConnection().prepareStatement(
//				"INSERT INTO TBL_MUSINSA_SAMPLE VALUES(?, ?, ?, ?, ?)");
//		pstmt.setString(1, map.get("no"));
//		pstmt.setString(2, map.get("title"));
//		pstmt.setString(3, map.get("info"));
//		pstmt.setString(4, map.get("price"));
//		pstmt.setString(5, map.get("link"));
//		pstmt.executeUpdate();
//		pstmt.close();
//	}
//	
//	static void doOldParsing() throws Exception {
//		String urlStr = "https://www.musinsa.com/category/014001";
//		URL url = new URL(urlStr);
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//		BufferedWriter bw = new BufferedWriter(new FileWriter("무신사.html"));
//		
//		String s = null;
//		while((s = br.readLine()) != null) {
//			System.out.println(s);
//			bw.write(s);
//			bw.newLine();
//		}
//		
//		bw.close();
//	}
}
