package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberJoinController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "member/member_join";
    }

    @Override
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto dto = MemberDto.builder()
                .id(request.getParameter("id"))
                .password(request.getParameter("password"))
                .name(request.getParameter("name"))
                .nickname(request.getParameter("nickname"))
                .email(request.getParameter("email"))
                .tel(request.getParameter("tel"))
                .build();

        int result = memberService.join(dto);

        if (result == 0) {
            request.setAttribute("msg", "중복된 아이디입니다! 다른 아이디로 가입해주세요!");
            request.setAttribute("member", dto);
            return "member/join";
        }

        return "redirect:/";
    }
}
