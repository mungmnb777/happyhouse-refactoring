package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {

    private static MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/member_join.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto dto = new MemberDto();

        dto.setId(request.getParameter("id"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));
        dto.setNickname(request.getParameter("nickname"));
        dto.setEmail(request.getParameter("email"));
        dto.setTel(request.getParameter("tel"));

        int result = memberService.join(dto);

        if (result != 0) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('가입에 성공했습니다!'); location.href='/';</script>");
        } else {
            request.setAttribute("msg", "중복된 아이디입니다! 다른 아이디로 가입해주세요!");
            request.setAttribute("member", dto);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/join.jsp");
            dispatcher.forward(request, response);
        }
    }
}
