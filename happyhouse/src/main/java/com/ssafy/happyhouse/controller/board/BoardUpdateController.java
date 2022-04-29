package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class BoardUpdateController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        int boardId = Integer.parseInt(parameters.get("boardId"));
        model.put("board", boardService.findById(boardId));
        return "board/board_update";
    }

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String memberId = parameters.get("author");
        int boardId = Integer.parseInt(parameters.get("boardId"));
        String title = parameters.get("title");
        String content = parameters.get("content");

        BoardDto boardDto = BoardDto.builder()
                .id(boardId)
                .title(title)
                .content(content)
                .build();

        if (memberId == null) return "redirect:/member/login";

        boardService.updateArticle(boardDto);

        return "redirect:/board/item?boardId=" + boardId;
    }
}
