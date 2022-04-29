package com.ssafy.happyhouse.view;

import com.google.gson.Gson;
import com.ssafy.happyhouse.view.entity.JsonEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class View {

    private final Object value;

    public View(Object value) {
        this.value = value;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        if (value instanceof JsonEntity) {
            // Google Gson 라이브러리 이용해서 리스트를 JSON으로 변환 후 ajax 통신
            response.getWriter().write(new Gson().toJson(((JsonEntity<?>) value).getValue()));
        }
        //view가 "xxx", "redirect:/xxx"인 경우
        else if (value instanceof String) {
            String[] redirect = ((String) value).split(":");

            // 리다이렉트 할 경우
            if (redirect[0].equals("redirect")) response.sendRedirect(redirect[1]);
            // 포워드 할 경우
            else request.getRequestDispatcher(viewResolve((String) value)).forward(request, response);
        }
    }

    private String viewResolve(String viewName) {
        String prefix = "/WEB-INF/views/";
        String suffix = ".jsp";

        return prefix + viewName + suffix;
    }
}
