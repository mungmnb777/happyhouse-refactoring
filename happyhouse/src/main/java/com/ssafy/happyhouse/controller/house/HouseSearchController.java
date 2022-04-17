package com.ssafy.happyhouse.controller.house;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.service.*;
import com.ssafy.util.Paging;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/house/items")
public class HouseSearchController extends HttpServlet {

    private final HouseService houseService = HouseServiceImpl.getInstace();
    private final PagingService pagingService = PagingServiceImpl.getInstace();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}