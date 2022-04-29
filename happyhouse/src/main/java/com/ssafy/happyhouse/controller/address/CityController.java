package com.ssafy.happyhouse.controller.address;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.AddressService;
import com.ssafy.happyhouse.service.AddressServiceImpl;
import com.ssafy.happyhouse.view.entity.JsonEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CityController implements Controller {

    private final AddressService addressService = AddressServiceImpl.getInstace();

    @Override
    public JsonEntity get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stateCode = request.getParameter("stateCode");

        return new JsonEntity(addressService.getCityList(stateCode));
    }

}
