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
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = (String) request.getSession().getAttribute("loginId");
        int boardId = Integer.parseInt(request.getParameter("boardId"));

        if (loginId == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인 후 해주세요!'); location.href='/member/login';</script>");
        }

        int result = boardService.deleteArticle(boardId);

        if (result != 0) {
            response.sendRedirect("/board/items");
        }
    }
}
