package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/board/insert")
public class BoardInsertController extends HttpServlet {

    private BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/board/board_insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = (String) request.getParameter("title");
        String content = (String) request.getParameter("content");
        String loginId = (String) request.getSession().getAttribute("loginId");

        MemberDto memberDto = new MemberDto();
        memberDto.setId(loginId);

        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(title);
        boardDto.setContent(content);
        boardDto.setMember(memberDto);

        int result = boardService.addArticle(boardDto);

        if (result != 0) {
            response.sendRedirect("/board/items");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인 후 해주세요!'); location.href='/member/login';</script>");
        }
    }
}
