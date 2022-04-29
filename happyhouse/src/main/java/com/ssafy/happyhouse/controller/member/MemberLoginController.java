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
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/member_login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto dto = MemberDto.builder()
                .id(request.getParameter("id"))
                .password(request.getParameter("password"))
                .build();

        boolean isLogin = memberService.login(dto);

        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("loginId", dto.getId());

            response.sendRedirect("/");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인에 실패했습니다! 아이디 및 비밀번호를 다시 확인해주세요!'); location.href='/member/login';</script>");
        }
    }
}
