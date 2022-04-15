package com.ssafy.happyhouse.dto;

import java.time.LocalDateTime;

public class BoardDto {
	// 공지사항 ID
	private int id;
	// 공지사항 제목
	private String title;
	// 공지사항 내용
	private String content;
	// 작성자
	private MemberDto member;
	// 글 작성 날짜
	private LocalDateTime cdate;
	// 글 수정 날짜
	private LocalDateTime udate;

	public BoardDto() {
		super();
	}

	public BoardDto(int id, String title, String content, MemberDto member, LocalDateTime cdate, LocalDateTime udate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.member = member;
		this.cdate = cdate;
		this.udate = udate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MemberDto getMember() {
		return member;
	}

	public void setMember(MemberDto member) {
		this.member = member;
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
	
	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", title=" + title + ", content=" + content + ", member=" + member + ", cdate="
				+ cdate + ", udate=" + udate + "]";
	}


}
