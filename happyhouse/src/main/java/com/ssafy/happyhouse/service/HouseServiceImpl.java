package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.HouseDao;
import com.ssafy.happyhouse.dao.HouseDaoImpl;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.util.Paging;

import java.util.List;

public class HouseServiceImpl implements HouseService{
	// 싱글턴
	private static HouseService service = new HouseServiceImpl();
	
	private HouseServiceImpl() {}
	
	public static HouseService getInstace() {
		return service;
	}

	private final HouseDao houseDao = HouseDaoImpl.getInstance();

	@Override
	public List<HouseDto> findList(String cityCode, Paging paging) {
		return houseDao.findList(cityCode, paging);
	}

}
