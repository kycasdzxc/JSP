package app;

import java.net.URLDecoder;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

public class Test2 {
	public static void main(String[] args) {
		String pw1 = BCrypt.hashpw("12345", BCrypt.gensalt());
		System.out.println(pw1);
		String pw2 = BCrypt.hashpw("12345", BCrypt.gensalt());
		System.out.println(pw2);
		
		System.out.println(BCrypt.checkpw("12345", pw1));
		System.out.println(BCrypt.checkpw("12345", pw2));
		
		System.out.println(pw1.equals(pw2));
//		Random random = new Random();
//		int result = random.nextInt(100000000);
////		System.out.println(result);
//		System.out.println("=====");
//		System.out.println(BCrypt.checkpw("45855635",
//				URLDecoder.decode("%242a%2410%24PUxv7MoRAFFoMYZqIXG7Vu7sDiUyElp41Nv1Wt4OMhxjfaBrNDF96")));
//		
//		// LPAD
	}
}