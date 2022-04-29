package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.FavPlaceService;
import com.ssafy.happyhouse.service.FavPlaceServiceImpl;
import com.ssafy.happyhouse.service.PagingService;
import com.ssafy.happyhouse.service.PagingServiceImpl;
import com.ssafy.util.Paging;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PlaceSearchController implements Controller {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstace();
    private final PagingService pagingService = PagingServiceImpl.getInstace();

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pg = request.getParameter("pg");
        String memberId = (String) request.getSession().getAttribute("loginId");

        MemberDto member = MemberDto.builder()
                .id(memberId)
                .build();

        // 로그인 한 상태가 아니면 비정상적인 접근!
        if (memberId == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인하고 접근해주세요!'); location.href='/member/login';</script>");
            return;
        }

        Paging paging = pagingService.getPaging(pg, member);

        List<FavPlaceDto> list = favPlaceService.findAll(memberId, paging);

        if (list != null) {
            request.setAttribute("paging", paging);
            request.setAttribute("list", list);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/favplace/fplace_list.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
