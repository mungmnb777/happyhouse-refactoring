package com.ssafy.happyhouse.dto;

import com.ssafy.happyhouse.dto.address.Dong;

public class FavPlaceDto {
	private int id;
	private MemberDto member;
	private Dong dong;

	public FavPlaceDto() {
		super();
	}

	public FavPlaceDto(int id, MemberDto member, Dong dong) {
		super();
		this.id = id;
		this.member = member;
		this.dong = dong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MemberDto getMember() {
		return member;
	}

	public void setMember(MemberDto member) {
		this.member = member;
	}

	public Dong getDong() {
		return dong;
	}

	public void setDong(Dong dong) {
		this.dong = dong;
	}

	@Override
	public String toString() {
		return "FavPlaceDto [id=" + id + ", member=" + member + ", dong=" + dong + "]";
	}

}
