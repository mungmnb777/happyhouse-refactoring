package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberUpdateController implements Controller<Object> {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("loginId");

        if (id == null) return "redirect:/member/login";

        MemberDto member = memberService.findById(id);

        request.setAttribute("member", member);

        return "member/member_update";
    }

    @Override
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");

        String loginId = (String) request.getSession().getAttribute("loginId");

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
        return "redirect:/";
    }
}
