package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagingDaoImpl implements PagingDao {

	// 싱글턴
	private static PagingDao dao = new PagingDaoImpl();

	private PagingDaoImpl() {}

	public static PagingDao getInstance() {
		return dao;
	}

	@Override
	public int getTotalCount(String cityCode) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt \n");
		sql.append("from houseinfo \n");
		sql.append("where city_code = ?");

		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, cityCode);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("cnt");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	@Override
	public int getTotalCount(MemberDto member) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt \n");
		sql.append("from favplace \n");
		sql.append("where member_id = ?");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, member.getId());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("cnt");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int getTotalCount() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt \n");
		sql.append("from board \n");

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("cnt");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
