package com.ssafy.happyhouse.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class WelcomeController implements Controller {

    @Override
    public String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "index";
    }
}
