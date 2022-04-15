package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.*;
import com.ssafy.util.Paging;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/place/stores")
public class StoreSearchController extends HttpServlet {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstace();
    private final PagingService pagingService = PagingServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pg = request.getParameter("pg");
        String memberId = (String) request.getSession().getAttribute("loginId");

        MemberDto member = new MemberDto();
        member.setId(memberId);

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

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/favplace/fplace_store_search.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
