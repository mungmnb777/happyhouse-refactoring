package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberSearchController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstance();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String id = (String) session.getAttribute("loginId");

        if (id == null) return "redirect:/member/login";

        MemberDto member = memberService.findById(id);

        model.put("member", member);

        return "member/member_search";
    }
}
