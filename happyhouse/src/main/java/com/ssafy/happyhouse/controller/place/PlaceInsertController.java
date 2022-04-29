package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.service.FavPlaceService;
import com.ssafy.happyhouse.service.FavPlaceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlaceInsertController implements Controller {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstace();

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
