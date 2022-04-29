package com.ssafy.happyhouse.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller<T> {
    default T get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

    default T post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
