package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        request.setAttribute("board", boardService.findById(boardId));
        return "board/board_update";
    }

    @Override
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("author");

        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

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
