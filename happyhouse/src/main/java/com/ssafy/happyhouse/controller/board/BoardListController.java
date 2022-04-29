package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;
import com.ssafy.happyhouse.service.PagingService;
import com.ssafy.happyhouse.service.PagingServiceImpl;
import com.ssafy.util.Paging;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardListController implements Controller {

    private final BoardService boardService = BoardServiceImpl.getInstace();
    private final PagingService pagingService = PagingServiceImpl.getInstace();

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pg = request.getParameter("pg");

        Paging paging = pagingService.getPaging(pg);

        List<BoardDto> list = boardService.findAll(paging);

        if (list != null) {
            request.setAttribute("list", list);
            request.setAttribute("paging", paging);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
