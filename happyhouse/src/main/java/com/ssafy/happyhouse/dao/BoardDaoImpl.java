package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.util.DBConnection;
import com.ssafy.util.Paging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
    // 싱글턴
    private static BoardDao dao = new BoardDaoImpl();

    private BoardDaoImpl() {
    }

    public static BoardDao getInstance() {
        return dao;
    }

    @Override
    public int addArticle(BoardDto dto) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into \n");
        sql.append(
                "board (title, content, author, board_cdate, board_udate) \n");
        sql.append("values (?, ?, ?, now(), now())");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getMember().getId());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<BoardDto> findAll(Paging paging) {
        List<BoardDto> list = new ArrayList<BoardDto>();

        StringBuilder listArticle = new StringBuilder();
        listArticle.append("select * \n");
        listArticle.append("from board join `member` \n");
        listArticle.append("on member_id = author \n");
        listArticle.append("order by board_cdate desc\n");
        listArticle.append("limit ?, ? \n");

        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(listArticle.toString())) {

            pstmt.setInt(1, (paging.getPage() - 1) * paging.getPostPerPage());
            pstmt.setInt(2, paging.getPostPerPage());

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // member DTO
                    MemberDto member = MemberDto.builder()
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

                    // board DTO
                    BoardDto dto = BoardDto.builder()
                            .id(rs.getInt("board_id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("title"))
                            .cdate(rs.getTimestamp("board_cdate").toLocalDateTime())
                            .udate(rs.getTimestamp("board_udate").toLocalDateTime())
                            .member(member)
                            .build();

                    list.add(dto);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BoardDto findById(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * \n");
        sql.append("from board join member \n");
        sql.append("on author = member_id \n");
        sql.append("where board_id = ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // member DTO
                    MemberDto member = MemberDto.builder()
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

                    // board DTO
                    BoardDto dto = BoardDto.builder()
                            .id(rs.getInt("board_id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .cdate(rs.getTimestamp("board_cdate").toLocalDateTime())
                            .udate(rs.getTimestamp("board_udate").toLocalDateTime())
                            .member(member)
                            .build();

                    return dto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int updateArticle(BoardDto dto) {
        StringBuilder sql = new StringBuilder();
        sql.append("update board \n");
        sql.append("set title = ?, content = ?, board_udate = now()\n");
        sql.append("where board_id = ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setInt(3, dto.getId());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteArticle(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from board \n");
        sql.append("where board_id = ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, id);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
