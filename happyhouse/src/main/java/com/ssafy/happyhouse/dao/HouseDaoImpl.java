package com.ssafy.happyhouse.dao;


import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.address.City;
import com.ssafy.happyhouse.dto.address.State;
import com.ssafy.util.DBConnection;
import com.ssafy.util.Paging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
	// 싱글턴
	private static HouseDao dao = new HouseDaoImpl();

	private HouseDaoImpl() {
	}

	public static HouseDao getInstance() {
		return dao;
	}

	@Override
	public List<HouseDto> findList(String cityCode, Paging paging) {
		List<HouseDto> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * \n");
		sql.append("from houseinfo h join city c \n");
		sql.append("using (city_code) \n");
		sql.append("join state s \n");
		sql.append("using (state_code) \n");
		sql.append("where city_code = ? \n");
		sql.append("limit ?, ?");

		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, cityCode);
			pstmt.setInt(2, (paging.getPage() - 1) * paging.getPostPerPage());
			pstmt.setInt(3, paging.getPostPerPage());

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					// State DTO 필드
					State findState = State.builder()
							.code(rs.getString("state_code"))
							.name(rs.getString("state_name"))
							.build();

					// City DTO 필드
					City findCity = City.builder()
							.state(findState)
							.code(rs.getString("city_code"))
							.name(rs.getString("city_name"))
							.build();

					// house DTO 필드
					HouseDto house = HouseDto.builder()
							.id(rs.getInt("house_id"))
							.name(rs.getString("house_name"))
							.price(rs.getString("deal_price"))
							.buildYear(rs.getString("build_year"))
							.dealYear(rs.getString("deal_year"))
							.dealMonth(rs.getString("deal_month"))
							.dealDay(rs.getString("deal_day"))
							.roadName(rs.getString("road_name"))
							.mainRoadNo(rs.getString("main_road_no"))
							.subRoadNo(rs.getString("sub_road_no"))
							.area(rs.getString("area"))
							.city(findCity)
							.build();

					list.add(house);
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
