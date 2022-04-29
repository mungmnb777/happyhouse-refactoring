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
import com.ssafy.happyhouse.view.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"", "/member/*", "/board/*", "/place/*", "/address/*", "/house/*"})
public class FrontController extends HttpServlet {

    private final Map<String, Controller> handlerMapping = new HashMap<>();

    public FrontController() {
        // WELCOME PAGE
        handlerMapping.put("/", new WelcomeController());
        // MEMBER PAGE
        handlerMapping.put("/member/join", new MemberJoinController());
        handlerMapping.put("/member/login", new MemberLoginController());
        handlerMapping.put("/member/item", new MemberSearchController());
        handlerMapping.put("/member/logout", new MemberLogoutController());
        handlerMapping.put("/member/update", new MemberUpdateController());
        handlerMapping.put("/member/delete", new MemberDeleteController());
        // BOARD PAGE
        handlerMapping.put("/board/items", new BoardListController());
        handlerMapping.put("/board/item", new BoardSearchController());
        handlerMapping.put("/board/insert", new BoardInsertController());
        handlerMapping.put("/board/update", new BoardUpdateController());
        handlerMapping.put("/board/delete", new BoardDeleteController());
        // HOUSE PAGE
        handlerMapping.put("/house/items", new HouseSearchController());
        // PLACE PAGE
        handlerMapping.put("/place/stores", new StoreSearchController());
        handlerMapping.put("/place/items", new PlaceSearchController());
        handlerMapping.put("/place/insert", new PlaceInsertController());
        handlerMapping.put("/place/delete", new PlaceDeleteController());
        // ADDRESS PAGE (for ajax)
        handlerMapping.put("/address/states", new StateController());
        handlerMapping.put("/address/cities", new CityController());
        handlerMapping.put("/address/dongs", new DongController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Method 및 리소스 URI 가져온 후 컨트롤러 매핑(기존 Spring의 핸들러 매핑 기능)
         */
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        Controller controller = handlerMapping.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        /**
         * 뷰에 대한 정보가 담긴다.
         * Patterns
         * "xxx" -> /WEB-INF/views/xxx.jsp로 포워딩
         * "redirect:/xxx" -> /xxx로 리다이렉트
         * "
         */
        View view = null;

        Map<String, String> parameters = getParameters(request);
        Map<String, Object> model = new HashMap<>();
        HttpSession session = request.getSession();

        switch (method) {
            case "GET":
                view = new View(controller.get(parameters, model, session));
                break;
            case "POST":
                view = new View(controller.post(parameters, model, session));
                break;
        }

        model.forEach((key, value) -> request.setAttribute(key, value));

        if (view != null) view.render(request, response);
        else response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    private Map<String, String> getParameters(HttpServletRequest request) {
        Map<String, String> parameters = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(parameter -> parameters.put(parameter, request.getParameter(parameter)));

        return parameters;
    }
}
