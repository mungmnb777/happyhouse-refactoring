package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.MemberDto;

public interface MemberDao {
	
	// 회원가입
	int join(MemberDto dto);
	
	// 로그인
	boolean login(MemberDto dto);
	
	// 회원 정보 수정
	int updateMember(MemberDto dto);
	
	// 회원 정보 삭제
	int deleteMember(String id);
	
	// 회원 정보 조회
	MemberDto findById(String id);
}
