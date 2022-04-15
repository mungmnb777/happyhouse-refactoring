package com.ssafy.happyhouse.dao;


import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.util.Paging;

import java.util.List;

public interface BoardDao {

	// 공지사항 추가
	public int addArticle(BoardDto dto);
	
	// 공지사항 목록 조회
	public List<BoardDto> findAll(Paging paging);
	
	// 공지사항 세부 조회
	public BoardDto findById(int id);
	
	// 공지사항 수정
	public int updateArticle(BoardDto dto);
	
	// 공지사항 삭제
	public int deleteArticle(int id);
}
