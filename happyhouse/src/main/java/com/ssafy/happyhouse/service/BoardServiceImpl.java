package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dao.BoardDao;
import com.ssafy.happyhouse.dao.BoardDaoImpl;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.util.Paging;

import java.util.List;

public class BoardServiceImpl implements BoardService{
	private BoardDao boardDao = BoardDaoImpl.getInstance();
	// 싱글턴
	private static BoardService service = new BoardServiceImpl();
	
	private BoardServiceImpl() {}
	
	public static BoardService getInstance() {
		return service;
	}

	@Override
	public int addArticle(BoardDto dto) {
		return boardDao.addArticle(dto);
	}
	// 페이지----------------------------------------------------------------
	@Override
	public List<BoardDto> findAll(Paging paging) {
		return boardDao.findAll(paging);
	}
	
	@Override
	public BoardDto findById(int id) {
		return boardDao.findById(id);
	}

	@Override
	public int updateArticle(BoardDto dto) {
		return boardDao.updateArticle(dto);
	}

	@Override
	public int deleteArticle(int id) {
		return boardDao.deleteArticle(id);
	}

}
