package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardSearchController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleNo = Integer.parseInt(request.getParameter("boardId"));

        BoardDto boardDto = boardService.findById(articleNo);
        request.setAttribute("board", boardDto);

        return "board/board_search";
    }
}
