package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardInsertController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("loginId") == null) return "redirect:/member/login";
        return "board/board_insert";
    }

    @Override
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String loginId = (String) request.getSession().getAttribute("loginId");

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
