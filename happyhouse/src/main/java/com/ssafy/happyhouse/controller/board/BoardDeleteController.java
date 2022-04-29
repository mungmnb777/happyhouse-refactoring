package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = (String) request.getSession().getAttribute("loginId");
        int boardId = Integer.parseInt(request.getParameter("boardId"));

        if (loginId == null) return "redirect:/member/login";

        boardService.deleteArticle(boardId);

        return "redirect:/board/items";
    }
}
