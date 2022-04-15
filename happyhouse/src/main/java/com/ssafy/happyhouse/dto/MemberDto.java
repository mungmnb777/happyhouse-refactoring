package com.ssafy.happyhouse.dto;

import java.time.LocalDateTime;

public class MemberDto {
	// 멤버 ID
	private String id;
	// 멤버 비밀번호
	private String password;
	// 멤버 이름
	private String name;
	// 멤버 닉네임
	private String nickname;
	// 멤버 이메일
	private String email;
	// 멤버 생성 날짜
	private LocalDateTime cdate;
	// 멤버 수정 날짜
	private LocalDateTime udate;
	// 멤버 전화번호
	private String tel;
	// 멤버 권한
	private String role;
	
	public MemberDto() {
		super();
	}

	public MemberDto(String id, String password, String name, String nickname, String email, LocalDateTime cdate, LocalDateTime udate,
			String tel, String role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.cdate = cdate;
		this.udate = udate;
		this.tel = tel;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCdate() {
		return cdate;
	}

	public void setCdate(LocalDateTime cdate) {
		this.cdate = cdate;
	}

	public LocalDateTime getUdate() {
		return udate;
	}

	public void setUdate(LocalDateTime udate) {
		this.udate = udate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", email=" + email + ", cdate=" + cdate + ", udate=" + udate + ", tel=" + tel + "]";
	}
}
