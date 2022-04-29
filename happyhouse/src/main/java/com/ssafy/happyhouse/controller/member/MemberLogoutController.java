package com.ssafy.happyhouse.controller.member;

import com.ssafy.happyhouse.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberLogoutController implements Controller {

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        session.removeAttribute("loginId");
        return "redirect:/";
    }
}
