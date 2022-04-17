package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/place/insert")
public class PlaceInsertController extends HttpServlet {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstace();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = (String) request.getSession().getAttribute("loginId");
        String dongCode = request.getParameter("dong");

        // 로그인 한 상태가 아니면 비정상적인 접근!
        if (memberId == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인하고 접근해주세요!'); location.href='/member/login';</script>");
            return;
        }

        MemberDto memberDto = MemberDto.builder()
                .id(memberId)
                .build();

        Dong dong = Dong.builder()
                .code(dongCode)
                .build();

        FavPlaceDto favPlaceDto = FavPlaceDto.builder()
                .member(memberDto)
                .dong(dong)
                .build();

        int result = favPlaceService.addFavPlace(favPlaceDto);

        if (result != 0) {
            response.sendRedirect("/place/items");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('이미 있는 위치 정보입니다!'); location.href='/place/items';</script>");
        }
    }
}
