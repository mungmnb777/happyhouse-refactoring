package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class BoardDeleteController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstance();

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String loginId = (String) session.getAttribute("loginId");
        int boardId = Integer.parseInt(parameters.get("boardId"));

        if (loginId == null) return "redirect:/member/login";

        boardService.deleteArticle(boardId);

        return "redirect:/board/items";
    }
}
