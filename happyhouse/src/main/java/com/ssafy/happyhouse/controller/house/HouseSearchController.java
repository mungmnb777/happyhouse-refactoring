package com.ssafy.happyhouse.controller.house;

import com.ssafy.happyhouse.controller.Controller;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.service.HouseService;
import com.ssafy.happyhouse.service.HouseServiceImpl;
import com.ssafy.happyhouse.service.PagingService;
import com.ssafy.happyhouse.service.PagingServiceImpl;
import com.ssafy.util.Paging;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HouseSearchController implements Controller {

    private final HouseService houseService = HouseServiceImpl.getInstance();
    private final PagingService pagingService = PagingServiceImpl.getInstance();

    @Override
    public String get(Map<String, String> parameters, Map<String, Object> model, HttpSession session) throws ServletException, IOException {
        // 페이지
        String pg = parameters.get("pg");
        String cityCode = parameters.get("cityCode");

        Paging paging = pagingService.getPaging(pg, cityCode);
        List<HouseDto> houseList = houseService.findList(cityCode, paging);

        model.put("houseList", houseList);
        model.put("paging", paging);

        return "house/house_list";
    }
}
