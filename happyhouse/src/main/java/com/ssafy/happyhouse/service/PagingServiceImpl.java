package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.PagingDao;
import com.ssafy.happyhouse.dao.PagingDaoImpl;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.util.Paging;

public class PagingServiceImpl implements PagingService {
	// 싱글턴
	private static PagingService service = new PagingServiceImpl();

	private PagingServiceImpl() {
	}

	public static PagingService getInstace() {
		return service;
	}

	private final PagingDao pagingDao = PagingDaoImpl.getInstance();

	@Override
	public Paging getPaging(String pg, String cityCode) {
		int page = pg != null ? Integer.parseInt(pg) : 1;
		
		return new Paging(pagingDao.getTotalCount(cityCode), page, 5, 5);
	}

	@Override
	public Paging getPaging(String pg, MemberDto member) {
		int page = pg != null ? Integer.parseInt(pg) : 1;
		
		return new Paging(pagingDao.getTotalCount(member), page, 5, 5);
	}

	@Override
	public Paging getPaging(String pg) {
		int page = pg != null ? Integer.parseInt(pg) : 1;
		
		return new Paging(pagingDao.getTotalCount(), page, 10, 10);
	}
	
}
