package com.ssafy.happyhouse.dto.address;

public class State {
	// 시도 코드
	private String code;
	// 시도 이름
	private String name;

	public State() {
		super();
	}

	public State(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
