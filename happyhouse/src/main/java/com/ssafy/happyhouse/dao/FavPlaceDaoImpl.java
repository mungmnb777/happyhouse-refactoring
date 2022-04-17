package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.FavPlaceDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.dto.address.City;
import com.ssafy.happyhouse.dto.address.Dong;
import com.ssafy.happyhouse.dto.address.State;
import com.ssafy.util.DBConnection;
import com.ssafy.util.Paging;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavPlaceDaoImpl implements FavPlaceDao {
    // 싱글턴
    private static FavPlaceDao dao = new FavPlaceDaoImpl();

    private FavPlaceDaoImpl() {
    }

    public static FavPlaceDao getInstance() {
        return dao;
    }

    @Override
    public List<FavPlaceDto> findAll(String memberId) {
        List<FavPlaceDto> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("select * \n");
        sql.append("from favPlace join member\n");
        sql.append("using (member_id) \n");
        sql.append("join dong \n");
        sql.append("using (dong_code) \n");
        sql.append("join city \n");
        sql.append("using (city_code) \n");
        sql.append("join state \n");
        sql.append("using (state_code) \n");
        sql.append("where member_id = ? \n");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, memberId);

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

                    // Dong DTO 필드
                    Dong findDong = Dong.builder()
                            .city(findCity)
                            .code(rs.getString("dong_code"))
                            .name(rs.getString("dong_name"))
                            .build();

                    // member DTO
                    MemberDto findMember = MemberDto.builder()
                            .id(rs.getString("member_id"))
                            .password(rs.getString("password"))
                            .name(rs.getString("member_name"))
                            .nickname(rs.getString("nickname"))
                            .email(rs.getString("email"))
                            .cdate(rs.getTimestamp("member_cdate").toLocalDateTime())
                            .udate(rs.getTimestamp("member_udate").toLocalDateTime())
                            .tel(rs.getString("tel"))
                            .role(rs.getString("role"))
                            .build();

                    FavPlaceDto favPlace = FavPlaceDto.builder()
                            .id(rs.getInt("fav_id"))
                            .member(findMember)
                            .dong(findDong)
                            .build();

                    list.add(favPlace);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FavPlaceDto> findAll(String memberId, Paging paging) {
        List<FavPlaceDto> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("select * \n");
        sql.append("from favPlace join member\n");
        sql.append("using (member_id) \n");
        sql.append("join dong \n");
        sql.append("using (dong_code) \n");
        sql.append("join city \n");
        sql.append("using (city_code) \n");
        sql.append("join state \n");
        sql.append("using (state_code) \n");
        sql.append("where member_id = ? \n");
        sql.append("limit ?, ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, memberId);
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

                    // Dong DTO 필드
                    Dong findDong = Dong.builder()
                            .city(findCity)
                            .code(rs.getString("dong_code"))
                            .name(rs.getString("dong_name"))
                            .build();

                    // member DTO
                    MemberDto findMember = MemberDto.builder()
                            .id(rs.getString("member_id"))
                            .password(rs.getString("password"))
                            .name(rs.getString("member_name"))
                            .nickname(rs.getString("nickname"))
                            .email(rs.getString("email"))
                            .cdate(rs.getTimestamp("member_cdate").toLocalDateTime())
                            .udate(rs.getTimestamp("member_udate").toLocalDateTime())
                            .tel(rs.getString("tel"))
                            .role(rs.getString("role"))
                            .build();

                    FavPlaceDto favPlace = FavPlaceDto.builder()
                            .id(rs.getInt("fav_id"))
                            .member(findMember)
                            .dong(findDong)
                            .build();

                    list.add(favPlace);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int addFavPlace(FavPlaceDto dto) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into \n");
        sql.append("favPlace (fav_id, member_id, dong_code) \n");
        sql.append("values(?, ?, ?)");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getMember().getId());
            pstmt.setString(3, dto.getDong().getCode());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteFavPlace(int favId) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from favPlace\n");
        sql.append("where fav_id = ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, favId);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
