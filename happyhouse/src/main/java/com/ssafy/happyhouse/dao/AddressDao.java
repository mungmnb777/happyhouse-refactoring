package com.ssafy.happyhouse.dao;


import com.ssafy.happyhouse.dto.address.City;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.dto.address.State;

import java.util.List;

public interface AddressDao {

	// state 리스트 전부 가져오기
	public List<State> getStateList();

	// 해당하는 state의 City 리스트 가져오기
	public List<City> getCityList(String stateCode);

	// 해당하는 city의 dong 리스트 가져오기
	public List<Dong> getDongList(String cityCode);
}
