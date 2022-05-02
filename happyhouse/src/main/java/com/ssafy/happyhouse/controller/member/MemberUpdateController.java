package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberUpdateController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstance();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String id = (String) session.getAttribute("loginId");

        if (id == null) return "redirect:/member/login";

        MemberDto member = memberService.findById(id);

        model.put("member", member);

        return "member/member_update";
    }

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String id = parameters.get("id");
        String nickname = parameters.get("nickname");
        String email = parameters.get("email");
        String tel = parameters.get("tel");

        String loginId = (String) session.getAttribute("loginId");

        // 로그인 아이디와 수정할 아이디가 같지 않으면 비정상적인 접근이다.
        if (!loginId.equals(id)) return "redirect:/";

        MemberDto dto = MemberDto.builder()
                .id(id)
                .nickname(nickname)
                .email(email)
                .tel(tel)
                .build();

        memberService.updateMember(dto);
        // 수정에 성공했으면 멤버 정보 조회 페이지로 리다이렉트한다.
        return "redirect:/member/item";
    }
}
