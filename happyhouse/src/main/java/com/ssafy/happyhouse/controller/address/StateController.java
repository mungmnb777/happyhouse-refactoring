package com.ssafy.happyhouse.controller.address;

import com.google.gson.Gson;
import com.ssafy.happyhouse.dto.address.State;
import com.ssafy.happyhouse.service.AddressService;
import com.ssafy.happyhouse.service.AddressServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/address/states")
public class StateController extends HttpServlet {

    private final AddressService addressService = AddressServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<State> stateList = addressService.getStateList();

        if (stateList != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            // Google Gson 라이브러리 이용해서 리스트를 JSON으로 변환 후 ajax 통신
            response.getWriter().write(new Gson().toJson(stateList));
        } else {
            response.getWriter().write("fail");
        }
    }
}
