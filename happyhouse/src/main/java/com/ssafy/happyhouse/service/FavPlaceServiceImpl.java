package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.FavPlaceDao;
import com.ssafy.happyhouse.dao.FavPlaceDaoImpl;
import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.util.Paging;

import java.util.List;

public class FavPlaceServiceImpl implements FavPlaceService{
	// 싱글턴
	private static FavPlaceService service = new FavPlaceServiceImpl();
	
	private FavPlaceServiceImpl() {}
	
	public static FavPlaceService getInstance() {
		return service;
	}

	private final FavPlaceDao favPlaceDao = FavPlaceDaoImpl.getInstance();

	@Override
	public List<FavPlaceDto> findAll(String memberId, Paging paging) {
		return favPlaceDao.findAll(memberId, paging);
	}

	@Override
	public int addFavPlace(FavPlaceDto dto) {
		List<FavPlaceDto> list = favPlaceDao.findAll(dto.getMember().getId());
		for(FavPlaceDto f : list) {
			// DB에 넣을 예정인 DTO의 code
			String code = dto.getDong().getCode();
			// 비교 대상 DTO의 code
			String findCode = f.getDong().getCode();
			
			// 만약 같으면 이미 DB에 똑같은 정보가 있다는 뜻이므로 0 반환
			if(code.equals(findCode)) {
				return 0;
			}
		}
		
		return favPlaceDao.addFavPlace(dto);
	}

	@Override
	public int deleteFavPlace(int favId) {
		return favPlaceDao.deleteFavPlace(favId);
	}
}
