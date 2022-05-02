package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class BoardInsertController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstance();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        if (session.getAttribute("loginId") == null) return "redirect:/member/login";
        return "board/board_insert";
    }

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String title = parameters.get("title");
        String content = parameters.get("content");
        String loginId = (String) session.getAttribute("loginId");

        if (loginId == null) return "redirect:/member/login";

        MemberDto memberDto = MemberDto.builder()
                .id(loginId)
                .build();

        BoardDto boardDto = BoardDto.builder()
                .title(title)
                .content(content)
                .member(memberDto)
                .build();

        boardService.addArticle(boardDto);

        return "redirect:/board/items";
    }
}
