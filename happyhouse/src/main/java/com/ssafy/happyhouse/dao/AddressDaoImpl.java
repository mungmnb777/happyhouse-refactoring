package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.address.City;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.dto.address.State;
import com.ssafy.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    // 싱글턴
    private static AddressDao dao = new AddressDaoImpl();

    private AddressDaoImpl() {
    }

    public static AddressDao getInstance() {
        return dao;
    }

    @Override
    public List<State> getStateList() {
        List<State> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("select * \n");
        sql.append("from state\n");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // state DTO
                    State state = State.builder()
                            .code(rs.getString("state_code"))
                            .name(rs.getString("state_name"))
                            .build();

                    list.add(state);
                }
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<City> getCityList(String stateCode) {
        List<City> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("select * \n");
        sql.append("from state s join city c \n");
        sql.append("using (state_code) \n");
        sql.append("where state_code = ? \n");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, stateCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // state DTO
                    State state = State.builder()
                            .code(rs.getString("state_code"))
                            .name(rs.getString("state_name"))
                            .build();

                    // city DTO
                    City city = City.builder()
                            .state(state)
                            .code(rs.getString("city_code"))
                            .name(rs.getString("city_name"))
                            .build();

                    list.add(city);
                }
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Dong> getDongList(String cityCode) {
        List<Dong> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("select * \n");
        sql.append("from dong join city \n");
        sql.append("using (city_code) \n");
        sql.append("join state \n");
        sql.append("using (state_code) \n");
        sql.append("where city_code = ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, cityCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // state DTO
                    State state = State.builder()
                            .code(rs.getString("state_code"))
                            .name(rs.getString("state_name"))
                            .build();

                    // city DTO
                    City city = City.builder()
                            .state(state)
                            .code(rs.getString("city_code"))
                            .name(rs.getString("city_name"))
                            .build();

                    // dong DTO
                    Dong dong = Dong.builder()
                            .city(city)
                            .code(rs.getString("dong_code"))
                            .name(rs.getString("dong_name"))
                            .build();

                    list.add(dong);
                }
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
