package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MemberDaoImpl implements MemberDao {
	// 싱글턴
	private static MemberDao dao = new MemberDaoImpl();

	private MemberDaoImpl() {
	}

	public static MemberDao getInstance() {
		return dao;
	}

	@Override
	public int join(MemberDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into \n");
		sql.append(
				"member (member_id, password, member_name, nickname, email, member_cdate, member_udate, tel, role) \n");
		sql.append("values(?, ?, ?, ?, ?, now(), now(), ?, 'general')");

		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getTel());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean login(MemberDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * \n");
		sql.append("from member \n");
		sql.append("where member_id = ? and password = ?");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());

			try (ResultSet rs = pstmt.executeQuery()) {
				// 로그인 성공
				if (rs.next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public int updateMember(MemberDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("update member \n");
		sql.append("set nickname = ?, email = ?, member_udate = now(), tel = ?\n");
		sql.append("where member_id = ?");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getId());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteMember(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from member \n");
		sql.append("where member_id = ?");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, id);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public MemberDto findById(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * \n");
		sql.append("from member \n");
		sql.append("where member_id = ?");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String password = rs.getString("password");
					String name = rs.getString("member_name");
					String nickname = rs.getString("nickname");
					LocalDateTime cdate = rs.getTimestamp("member_cdate").toLocalDateTime();
					LocalDateTime udate = rs.getTimestamp("member_udate").toLocalDateTime();
					String email = rs.getString("email");
					String tel = rs.getString("tel");
					String role = rs.getString("role");

					return new MemberDto(id, password, name, nickname, email, cdate, udate, tel, role);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return null;
	}
}
