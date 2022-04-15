package com.ssafy.happyhouse.controller.board;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.BoardServiceImpl;
import com.ssafy.happyhouse.service.PagingService;
import com.ssafy.happyhouse.service.PagingServiceImpl;
import com.ssafy.util.Paging;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/board/items")
public class BoardListController extends HttpServlet {

    private BoardService boardService = BoardServiceImpl.getInstace();
    private PagingService pagingService = PagingServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
