package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/place/delete")
public class PlaceDeleteController extends HttpServlet {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstace();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
