package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.FavPlaceService;
import com.ssafy.happyhouse.service.FavPlaceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlaceDeleteController implements Controller {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstace();

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int favId = Integer.parseInt(request.getParameter("favId"));

        int result = favPlaceService.deleteFavPlace(favId);

        String memberId = (String) request.getSession().getAttribute("loginId");

        // 로그인 한 상태가 아니면 비정상적인 접근!
        if (memberId == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인하고 접근해주세요!'); location.href='/member/login';</script>");
            return;
        }

        if (result != 0) {
            response.sendRedirect("/place/items");
        }
    }
}
