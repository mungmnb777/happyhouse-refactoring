package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.address.City;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.dto.address.State;

import java.util.List;

public interface AddressService {

	// state 리스트 전부 가져오기
	List<State> getStateList();

	// 해당하는 state의 City 리스트 가져오기
	List<City> getCityList(String stateCode);

	// 해당하는 city의 dong 리스트 가져오기
	List<Dong> getDongList(String cityCode);
}
