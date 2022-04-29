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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"", "/member/*", "/board/*", "/place/*", "/address/*", "/house/*"})
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
        /**
         * Method 및 리소스 URI 가져온 후 컨트롤러 매핑(기존 Spring의 핸들러 매핑 기능)
         */
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        Controller controller = controllerMap.get(requestURI);

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
        Object viewEntity = null;

        switch (method) {
            case "GET":
                viewEntity = controller.get(request, response);
                break;
            case "POST":
                viewEntity = controller.post(request, response);
                break;
        }

        View view = new View(viewEntity);

        view.render(request, response);
    }
}
