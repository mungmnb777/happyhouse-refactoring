package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

    private static MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/member_login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto dto = MemberDto.builder()
                .id(request.getParameter("id"))
                .password(request.getParameter("password"))
                .build();

        boolean isLogin = memberService.login(dto);

        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("loginId", dto.getId());
            //-----------------------------------------------
            session.setAttribute("member", dto);
            //-----------------------------------------------
            response.sendRedirect("/");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인에 실패했습니다! 아이디 및 비밀번호를 다시 확인해주세요!'); location.href='/member/login';</script>");
        }
    }
}
