package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.util.Paging;

import java.util.List;

public interface BoardService {
	// 공지사항 추가
	int addArticle(BoardDto dto);
	
	// 공지사항 목록 조회
	List<BoardDto> findAll(Paging paging);
	
	// 공지사항 세부 조회
	BoardDto findById(int id);
	
	// 공지사항 수정
	int updateArticle(BoardDto dto);
	
	// 공지사항 삭제
	int deleteArticle(int id);
}
