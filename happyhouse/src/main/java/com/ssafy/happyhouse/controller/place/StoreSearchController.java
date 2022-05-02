package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.FavPlaceService;
import com.ssafy.happyhouse.service.FavPlaceServiceImpl;
import com.ssafy.happyhouse.service.PagingService;
import com.ssafy.happyhouse.service.PagingServiceImpl;
import com.ssafy.util.Paging;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StoreSearchController implements Controller {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstance();
    private final PagingService pagingService = PagingServiceImpl.getInstance();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String pg = parameters.get("pg");
        String memberId = (String) session.getAttribute("loginId");

        MemberDto member = MemberDto.builder()
                .id(memberId)
                .build();

        // 로그인 한 상태가 아니면 로그인 페이지로 리다이렉트
        if (memberId == null) return "redirect:/member/login";

        Paging paging = pagingService.getPaging(pg, member);
        List<FavPlaceDto> list = favPlaceService.findAll(memberId, paging);

        model.put("paging", paging);
        model.put("list", list);

        return "favplace/fplace_store_search";
    }
}
