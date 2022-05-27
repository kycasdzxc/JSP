package member.service;

import java.util.List;

import member.dao.MemberDao;
import member.vo.MemberVo;

public class MemberServiceImpl implements MemberService{
	private static final MemberService memberService = new MemberServiceImpl();
	public static MemberService getInstance() {
		return memberService;
	}
	private MemberServiceImpl() {}
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public List<MemberVo> list() {
		return memberDao.list();
	}
	
	@Override
	public void register(MemberVo memberVo) {
		memberDao.register(memberVo);
	}
	@Override
	public void remove(String id) {
		memberDao.remove(id);
	}
	
	@Override
	public MemberVo login(String id, String pwd) {
		return memberDao.login(id, pwd);
	}
}
