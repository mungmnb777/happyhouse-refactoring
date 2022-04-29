package com.ssafy.happyhouse.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class WelcomeController implements Controller {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
