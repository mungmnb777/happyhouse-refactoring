package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSearchController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("loginId");

        if (id == null) return "redirect:/member/login";

        MemberDto member = memberService.findById(id);

        request.setAttribute("member", member);

        return "member/member_search";
    }
}
