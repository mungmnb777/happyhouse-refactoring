package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/board/item")
public class BoardSearchController extends HttpServlet {

    private BoardService boardService = BoardServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleNo = Integer.parseInt(request.getParameter("boardId"));

        BoardDto boardDto = boardService.findById(articleNo);
        request.setAttribute("board", boardDto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/board/board_search.jsp");
        dispatcher.forward(request, response);
    }
}
