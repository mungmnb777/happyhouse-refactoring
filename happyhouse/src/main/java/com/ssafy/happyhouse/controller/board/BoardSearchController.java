package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class BoardSearchController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        int articleNo = Integer.parseInt(parameters.get("boardId"));

        BoardDto boardDto = boardService.findById(articleNo);
        model.put("board", boardDto);

        return "board/board_search";
    }
}
