package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/board/update")
public class BoardUpdateController extends HttpServlet {

    private BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        BoardDto boardDto = boardService.findById(boardId);
        request.setAttribute("board", boardDto);
        request.getRequestDispatcher("/WEB-INF/views/board/board_update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = (String) request.getSession().getAttribute("loginId");
        String memberId = request.getParameter("author");

        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardDto boardDto = BoardDto.builder()
                .id(boardId)
                .title(title)
                .content(content)
                .build();

        if (memberId == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인 후 해주세요!'); location.href='/member/login';</script>");
        }
        if (!loginId.equals(memberId)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('잘못된 접근입니다!'); location.href = '/board/item?boardId=" + boardId + "';</script>");
        }

        int result = boardService.updateArticle(boardDto);

        if (result != 0) {
            response.sendRedirect("/board/item?boardId=" + boardId);
        }
    }
}
