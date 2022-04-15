package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.dao.MemberDaoImpl;
import com.ssafy.happyhouse.dto.MemberDto;

public class MemberServiceImpl implements MemberService{
	// 싱글턴
	private static MemberService service = new MemberServiceImpl();
	
	private MemberServiceImpl() {}
	
	public static MemberService getInstace() {
		return service;
	}
	
	private final MemberDao memberDao = MemberDaoImpl.getInstance();

	@Override
	public int join(MemberDto dto) {
		return memberDao.join(dto);
	}

	@Override
	public boolean login(MemberDto dto) {
		return memberDao.login(dto);
	}

	@Override
	public int updateMember(MemberDto dto) {
		return memberDao.updateMember(dto);
	}

	@Override
	public int deleteMember(String id) {
		return memberDao.deleteMember(id);
	}

	@Override
	public MemberDto findById(String id) {
		return memberDao.findById(id);
	}
}
