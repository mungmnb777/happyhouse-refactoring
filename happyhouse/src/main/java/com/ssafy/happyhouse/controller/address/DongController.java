package com.ssafy.happyhouse.controller.address;

import com.google.gson.Gson;
import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.service.AddressService;
import com.ssafy.happyhouse.service.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DongController implements Controller {

    private final AddressService addressService = AddressServiceImpl.getInstace();

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityCode = request.getParameter("cityCode");

        List<Dong> dongList = addressService.getDongList(cityCode);

        if (dongList != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            // Google Gson 라이브러리 이용해서 리스트를 JSON으로 변환 후 ajax 통신
            response.getWriter().write(new Gson().toJson(dongList));
        } else {
            response.getWriter().write("fail");
        }
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
