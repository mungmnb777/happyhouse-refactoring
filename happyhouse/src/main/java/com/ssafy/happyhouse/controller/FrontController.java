package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.controller.address.CityController;
import com.ssafy.happyhouse.controller.address.DongController;
import com.ssafy.happyhouse.controller.address.StateController;
import com.ssafy.happyhouse.controller.board.*;
import com.ssafy.happyhouse.controller.house.HouseSearchController;
import com.ssafy.happyhouse.controller.member.*;
import com.ssafy.happyhouse.controller.place.PlaceDeleteController;
import com.ssafy.happyhouse.controller.place.PlaceInsertController;
import com.ssafy.happyhouse.controller.place.PlaceSearchController;
import com.ssafy.happyhouse.controller.place.StoreSearchController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"", "/member/*", "/board/*", "/address/*", "/house/*"})
public class FrontController extends HttpServlet {

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public FrontController() {
        // WELCOME PAGE
        controllerMap.put("/", new WelcomeController());
        // MEMBER PAGE
        controllerMap.put("/member/join", new MemberJoinController());
        controllerMap.put("/member/login", new MemberLoginController());
        controllerMap.put("/member/item", new MemberSearchController());
        controllerMap.put("/member/logout", new MemberLogoutController());
        controllerMap.put("/member/update", new MemberUpdateController());
        controllerMap.put("/member/delete", new MemberDeleteController());
        // BOARD PAGE
        controllerMap.put("/board/items", new BoardListController());
        controllerMap.put("/board/item", new BoardSearchController());
        controllerMap.put("/board/insert", new BoardInsertController());
        controllerMap.put("/board/update", new BoardUpdateController());
        controllerMap.put("/board/delete", new BoardDeleteController());
        // HOUSE PAGE
        controllerMap.put("/house/items", new HouseSearchController());
        // PLACE PAGE
        controllerMap.put("/place/stores", new StoreSearchController());
        controllerMap.put("/place/items", new PlaceSearchController());
        controllerMap.put("/place/insert", new PlaceInsertController());
        controllerMap.put("/place/delete", new PlaceDeleteController());
        // ADDRESS PAGE (for ajax)
        controllerMap.put("/address/states", new StateController());
        controllerMap.put("/address/cities", new CityController());
        controllerMap.put("/address/dongs", new DongController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        Controller controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        switch (method) {
            case "GET":
                controller.get(request, response);
                break;
            case "POST":
                controller.post(request, response);
                break;
        }
    }
}
