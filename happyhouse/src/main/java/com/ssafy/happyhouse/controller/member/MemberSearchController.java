package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/member/item")
public class MemberSearchController extends HttpServlet {

    private static MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
