package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberLoginController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        return "member/member_login";
    }

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        MemberDto dto = MemberDto.builder()
                .id(parameters.get("id"))
                .password(parameters.get("password"))
                .build();

        boolean isLogin = memberService.login(dto);

        if (!isLogin) {
            return "redirect:/member/login";
        }

        session.setAttribute("loginId", dto.getId());
        return "redirect:/";
    }
}
