package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;
import com.ssafy.happyhouse.service.PagingService;
import com.ssafy.happyhouse.service.PagingServiceImpl;
import com.ssafy.util.Paging;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BoardListController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();
    private final PagingService pagingService = PagingServiceImpl.getInstace();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String pg = parameters.get("pg");

        Paging paging = pagingService.getPaging(pg);

        List<BoardDto> list = boardService.findAll(paging);

        model.put("list", list);
        model.put("paging", paging);

        return "board/board_list";
    }
}
