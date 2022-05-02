package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberJoinController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstance();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        return "member/member_join";
    }

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        MemberDto dto = MemberDto.builder()
                .id(parameters.get("id"))
                .password(parameters.get("password"))
                .name(parameters.get("name"))
                .nickname(parameters.get("nickname"))
                .email(parameters.get("email"))
                .tel(parameters.get("tel"))
                .build();

        int result = memberService.join(dto);

        if (result == 0) {
            model.put("msg", "중복된 아이디입니다! 다른 아이디로 가입해주세요!");
            model.put("member", dto);
            return "member/join";
        }

        return "redirect:/";
    }
}
