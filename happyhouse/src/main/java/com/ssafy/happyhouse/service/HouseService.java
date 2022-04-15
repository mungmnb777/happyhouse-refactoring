package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.util.Paging;

import java.util.List;

public interface HouseService {
	// city code에 해당하는 아파트 리스트 얻기
	List<HouseDto> findList(String cityCode, Paging paging);

}
