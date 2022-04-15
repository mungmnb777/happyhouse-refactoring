package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/member/update")
public class MemberUpdateController extends HttpServlet {

    private static MemberService memberService = MemberServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("loginId");

        if (id == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('로그인 후 접근해주세요!'); location.href='member?action=loginPage';</script>");
            return;
        }

        MemberDto member = memberService.findById(id);

        request.setAttribute("member", member);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/member_update.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto dto = new MemberDto();

        String id = request.getParameter("id");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");

        String loginId = (String) request.getSession().getAttribute("loginId");

        // 로그인 아이디와 수정할 아이디가 같지 않으면 비정상적인 접근이다.
        if (!loginId.equals(id)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('비정상적인 접근입니다!'); location.href='/';</script>");
            return;
        }

        dto.setId(id);
        dto.setNickname(nickname);
        dto.setEmail(email);
        dto.setTel(tel);

        int result = memberService.updateMember(dto);

        // 수정에 성공했으면 멤버 정보 조회 페이지로 리다이렉트한다.
        if (result != 0) {
            response.sendRedirect("/member/item");
        } else {
            response.getWriter().write("fail");
        }
    }
}
