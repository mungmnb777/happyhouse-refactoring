package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.AddressDao;
import com.ssafy.happyhouse.dao.AddressDaoImpl;
import com.ssafy.happyhouse.dto.address.City;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.dto.address.State;

import java.util.List;

public class AddressServiceImpl implements AddressService {
	// 싱글턴
	private static AddressService service = new AddressServiceImpl();

	private AddressServiceImpl() {
	}

	public static AddressService getInstance() {
		return service;
	}

	private final AddressDao houseDao = AddressDaoImpl.getInstance();

	@Override
	public List<State> getStateList() {
		return houseDao.getStateList();
	}

	@Override
	public List<City> getCityList(String stateCode) {
		return houseDao.getCityList(stateCode);
	}

	@Override
	public List<Dong> getDongList(String cityCode) {
		return houseDao.getDongList(cityCode);
	}
}
