package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.util.Paging;

import java.util.List;

public interface FavPlaceService {
	// 멤버의 관심지역 리스트 전부 가져오기(페이징 후)
	List<FavPlaceDto> findAll(String memberId, Paging paging);
	
	// 관심 지역 등록
	int addFavPlace(FavPlaceDto dto);
	
	// 관심 지역 삭제
	int deleteFavPlace(int favId);
}
