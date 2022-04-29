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
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/board/board_insert.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String loginId = (String) request.getSession().getAttribute("loginId");

        MemberDto memberDto = MemberDto.builder()
                .id(loginId)
                .build();

        BoardDto boardDto = BoardDto.builder()
                .title(title)
                .content(content)
                .member(memberDto)
                .build();

        int result = boardService.addArticle(boardDto);

        if (result != 0) {
            response.sendRedirect("/board/items");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인 후 해주세요!'); location.href='/member/login';</script>");
        }
    }
}
