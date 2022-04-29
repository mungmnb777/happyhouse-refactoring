package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberLoginController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "member/member_login";
    }

    @Override
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto dto = MemberDto.builder()
                .id(request.getParameter("id"))
                .password(request.getParameter("password"))
                .build();

        boolean isLogin = memberService.login(dto);

        if (!isLogin) {
            return "redirect:/member/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginId", dto.getId());
        return "redirect:/";
    }
}
