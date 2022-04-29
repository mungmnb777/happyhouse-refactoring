package com.ssafy.happyhouse.controller.address;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.AddressService;
import com.ssafy.happyhouse.service.AddressServiceImpl;
import com.ssafy.happyhouse.view.entity.JsonEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class CityController implements Controller {

    private final AddressService addressService = AddressServiceImpl.getInstace();

    @Override
    public JsonEntity get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String stateCode = parameters.get("stateCode");

        return new JsonEntity(addressService.getCityList(stateCode));
    }

}
