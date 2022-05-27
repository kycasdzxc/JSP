package dao;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import domain.Member;
import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDaoTests {
	private MemberDao memberDao = MemberDao.getInstance();
	
//	private Logger log = Logger.getLogger(MemberDaoTests.class);
	
	@Test
	public void testExist() {
		log.info(memberDao);
	}
	
	@Test
	public void testLogin() {
		Member member = memberDao.login("javaman", "1234");
		log.info(member);
		assertNotNull(member);
	}
	
//	@Test
//	public void testEquals() {
//		int[] arr = {1, 2, 3, 4, 5};
//		int[] arr2 = {1, 2, 3, 4, 5};
//		
//		log.info(arr);
//		log.info(arr2);
//		log.info(arr == arr2);
//		log.info(Arrays.equals(arr, arr2));
//		Assert.assertArrayEquals(arr, arr2);
//	}
//	
	@Test
	public void testEquals2() {
		String str = new String("12345");
		String str2 = new String("12345");
		
		log.info(str == str2);
		log.info(str.equals(str2));
//		Assert.assertEquals(str, str2);
		Assert.assertSame(str, str2);
	}
//	
//	@Test
//	public void testRegister() {
//		Member member = new Member();
//		member.setId("javaman2");
//		memberDao.register(member);
//	}
}