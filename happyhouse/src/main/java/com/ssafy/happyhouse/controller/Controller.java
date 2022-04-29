package com.ssafy.happyhouse.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface Controller {
    default Object get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        return null;
    }

    default Object post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        return null;
    }
}
