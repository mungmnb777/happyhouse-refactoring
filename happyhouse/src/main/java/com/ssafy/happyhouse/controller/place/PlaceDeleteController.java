package com.ssafy.happyhouse.controller.place;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.service.FavPlaceService;
import com.ssafy.happyhouse.service.FavPlaceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class PlaceDeleteController implements Controller {

    private final FavPlaceService favPlaceService = FavPlaceServiceImpl.getInstace();

    @Override
    public String post(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        int favId = Integer.parseInt(parameters.get("favId"));

        // 로그인 한 상태가 아니면 비정상적인 접근!
        if (session.getAttribute("loginId") == null) return "redirect:/member/login";

        favPlaceService.deleteFavPlace(favId);

        return "redirect:/place/items";
    }
}
