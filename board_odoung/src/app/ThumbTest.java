package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ThumbTest {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\Desktop\\thumb", "origin.jpg");
		Thumbnails
			.of(new File("C:\\Users\\user\\Desktop\\thumb", "origin.jpg"))
//			.sourceRegion(Positions.TOP_CENTER, 200, 200)
			.size(200, 200)
//			.forceSize(200, 200)
			.crop(Positions.CENTER)
			.toFile(new File("C:\\Users\\user\\Desktop\\thumb", "result3.jpg"));
			
		
		String contextType = Files.probeContentType(file.toPath());
		System.out.println(contextType.startsWith("image"));
	}
}
