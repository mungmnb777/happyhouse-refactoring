package com.ssafy.happyhouse.controller.house;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.service.HouseService;
import com.ssafy.happyhouse.service.HouseServiceImpl;
import com.ssafy.happyhouse.service.PagingService;
import com.ssafy.happyhouse.service.PagingServiceImpl;
import com.ssafy.util.Paging;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HouseSearchController implements Controller {

    private final HouseService houseService = HouseServiceImpl.getInstace();
    private final PagingService pagingService = PagingServiceImpl.getInstace();

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 페이지
        String pg = request.getParameter("pg");
        String cityCode = request.getParameter("cityCode");

        Paging paging = pagingService.getPaging(pg, cityCode);
        List<HouseDto> houseList = houseService.findList(cityCode, paging);

        if (houseList != null) {
            request.setAttribute("houseList", houseList);
            request.setAttribute("paging", paging);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/house/house_list.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().write("fail");
        }
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
