package com.ssafy.happyhouse.controller.address;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.AddressService;
import com.ssafy.happyhouse.service.AddressServiceImpl;
import com.ssafy.happyhouse.view.entity.JsonEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class DongController implements Controller {

    private final AddressService addressService = AddressServiceImpl.getInstance();

    @Override
    public JsonEntity get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        String cityCode = parameters.get("cityCode");

        return new JsonEntity(addressService.getDongList(cityCode));
    }
}
