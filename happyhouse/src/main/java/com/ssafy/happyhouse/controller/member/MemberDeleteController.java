package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet {

    private static MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        int result = memberService.deleteMember(id);

        String loginId = (String) request.getSession().getAttribute("loginId");

        // 로그인 아이디와 삭제할 아이디가 같지 않으면 비정상적인 접근이다.
        if (!loginId.equals(id)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('비정상적인 접근입니다!'); location.href='/';</script>");
            return;
        }

        // 삭제에 성공했으면 세션을 삭제하고 웰컴 페이지로 이동한다.
        if (result != 0) {
            request.getSession().removeAttribute("loginId");
            response.sendRedirect("/");
        } else {
            response.getWriter().write("fail");
        }
    }
}
