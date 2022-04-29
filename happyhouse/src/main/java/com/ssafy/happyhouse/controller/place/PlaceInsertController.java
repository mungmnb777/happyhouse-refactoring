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
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = (String) request.getSession().getAttribute("loginId");
        String dongCode = request.getParameter("dong");

        // 로그인 한 상태가 아니면 비정상적인 접근!
        if (memberId == null) return "redirect:/member/login";

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

        favPlaceService.addFavPlace(favPlaceDto);

        return "redirect:/place/items";
    }
}
