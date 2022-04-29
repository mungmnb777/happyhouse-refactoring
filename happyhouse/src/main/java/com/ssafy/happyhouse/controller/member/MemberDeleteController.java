package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberDeleteController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String id = parameters.get("id");

        memberService.deleteMember(id);

        String loginId = (String) session.getAttribute("loginId");

        // 로그인 아이디와 삭제할 아이디가 같지 않으면 비정상적인 접근이다.
        if (!loginId.equals(id)) return "redirect:/";

        // 삭제에 성공했으면 세션을 삭제하고 웰컴 페이지로 이동한다.
        session.removeAttribute("loginId");
        return "redirect:/";
    }
}
