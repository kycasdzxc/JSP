package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import domain.Member;

public class Util {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<Member> c = Member.class;
		System.out.println(c);
		
		Member member = c.newInstance();
		member.setId("userId");
		member.setPw("1234");
		
//		Field[] fields = c.getFields();
//		
//		for(Field field : fields) {
//			System.out.println(field);
//		}
		
		Method[] methods = c.getMethods();
		
		for(Method method : methods) {
			String name = method.getName();
			if(name.startsWith("set")) {
//				System.out.println(name);
//				System.out.println((char)(name.charAt(3) + 32));
//				System.out.println((char)(name.charAt(3) + 32) + name.substring(4));
				method.invoke(member, "1234");
			}
		}
		for(Method method : methods) {
			String name = method.getName();
			if(name.startsWith("get")) {
				System.out.println(name);
				System.out.println(method.invoke(member, new Object[] {}));
			}
		}
	}

	public static <T> T getParam(HttpServletRequest req, Class<T> c) {
		T t = null;
		try {
			t = c.newInstance();
			Method[] methods = c.getMethods();
			
			for(Method method : methods) {
				String name = method.getName();
				if(name.startsWith("set")) {
					method.invoke(t, req.getParameter((char)(name.charAt(3) + 32) + name.substring(4)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
