package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.util.Paging;

public interface PagingService {
	Paging getPaging(String pg, String cityCode);
	
	Paging getPaging(String pg, MemberDto member);
	
	Paging getPaging(String pg);
}
