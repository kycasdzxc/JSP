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

public class HTMLParser3 {
	public static void main(String[] args) throws Exception{
		Connection conn = Jsoup.connect("https://www.goodchoice.kr/product/search/3");
		Document doc = conn.get();
		Elements elements = doc.select(".list_2");
		for(int i = 0; i < 7 ; i++) {
			Element el = elements.get(i);
			
			String link = el.getElementsByTag("a").attr("href");
			System.out.println("링크 : " + link);
			
			conn = Jsoup.connect(link);
			Document doc2 = conn.get();
			
			Elements img1 = doc2.select(".swiper-slide").select("img");
//			String imgt = img1.outerHtml();
//			System.out.println(imgt);
			for(int z = 0 ; z < 5 ; z++) {
				Element el2 = img1.get(z);
				
				String img = el2.attr("data-src");
				
				System.out.println(z+1 + "번째 사진 : " +img);
			}
			String address=doc2.select(".address").text();
			System.out.println("주소 : "+address);
			
			String comment=doc2.select(".comment div").html();
			System.out.println("코멘트 : "+comment);
			
			String img3=doc2.select(".pic_view").select(".lazy").attr("data-original");
			System.out.println(img3);
			
			String title = doc2.select("strong.title").text();
			System.out.println(title);
			
			String price = doc2.select(".price").select("b").text();
			System.out.println("가격 : "+price);
			
////			System.out.println(doc2);
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
//			System.out.println(no + "번 작업 완료");
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
