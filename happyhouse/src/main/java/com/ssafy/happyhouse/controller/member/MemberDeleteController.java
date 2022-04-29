package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberDeleteController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        memberService.deleteMember(id);

        String loginId = (String) request.getSession().getAttribute("loginId");

        // 로그인 아이디와 삭제할 아이디가 같지 않으면 비정상적인 접근이다.
        if (!loginId.equals(id)) return "redirect:/";

        // 삭제에 성공했으면 세션을 삭제하고 웰컴 페이지로 이동한다.
        request.getSession().removeAttribute("loginId");
        return "redirect:/";
    }
}
