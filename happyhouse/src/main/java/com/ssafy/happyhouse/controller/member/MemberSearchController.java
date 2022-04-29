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

public class MemberSearchController implements Controller {

    private final MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("loginId");

        if (id == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인 후 접근해주세요!'); location.href='/member/login';</script>");
            return;
        }

        MemberDto member = memberService.findById(id);

        request.setAttribute("member", member);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/member_search.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
