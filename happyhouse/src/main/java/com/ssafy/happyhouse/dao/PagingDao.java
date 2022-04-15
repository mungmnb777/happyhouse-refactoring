package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.MemberDto;

public interface PagingDao {
	// 페이징을 위한 count 가져오기
	public int getTotalCount(String cityCode);
	
	public int getTotalCount(MemberDto member);
	
	public int getTotalCount();
}
